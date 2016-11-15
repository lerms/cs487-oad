package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import com.cs487.oad.util.QueryField;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderlerma on 11/8/16.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    private final MongoOperations operations;

    @Autowired
    public CategoryRepositoryImpl(MongoOperations operations) {
        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
    }

    @Override
    public void updateName(String name, String newName) {
        Query query = RepositoryUtils.simpleQuery(QueryField.NAME, name);
        Category toUpdate = operations.findOne(query, Category.class);
        toUpdate.setName(name);
        operations.save(toUpdate);
        buildCategoryAncestorsFull(toUpdate);
    }

    @Override
    public void updateSlug(String slug, String newSlug) {
        Query query = RepositoryUtils.simpleQuery(QueryField.SLUG, slug);
        Category toUpdate = operations.findOne(query, Category.class);
        toUpdate.setSlug(newSlug);
        operations.save(toUpdate);
        buildCategoryAncestorsFull(toUpdate);
    }

    @Override
    public void updateAncestors(String id, List<Category> newAncestors) {
        Query query = RepositoryUtils.simpleQuery(QueryField.ID, id);
        Category toUpdate = operations.findOne(query, Category.class);
        toUpdate.setAncestors(newAncestors);
        buildCategoryAncestorsFull(toUpdate);
    }

    @Override
    public void saveCategory(Category category) {
        Preconditions.checkNotNull(category);
        operations.save(category);
        Query query = RepositoryUtils.simpleQuery(QueryField.NAME, category.getName());
        category = operations.findOne(query, Category.class);;
        buildCategoryAncestors(category);
    }

    @Override
    public void deleteCategory(Category category) {

    }

    private void rebuildCategoryHierarchy(Category category) {
        Query query = Query.query(Criteria
                .where(QueryField.ANCESTORS + "." + QueryField.ID)
                .is(category.getId()));
        List<Category> rebuild = operations.find(query, Category.class);
        rebuild.forEach(this::buildCategoryAncestorsFull);
    }

    private void buildCategoryAncestors(Category child) {
        Query childQuery =  RepositoryUtils.simpleQuery(QueryField.ID, child.getId());
        child = operations.findOne(childQuery, Category.class);
        Query parentQuery =  RepositoryUtils.simpleQuery(QueryField.ID, child.getParentId());
        Category parent = operations.findOne(parentQuery, Category.class);
        List<Category> ancestors = new ArrayList<>();
        ancestors.add(parent);
        ancestors.addAll(parent.getAncestors());
        child.setAncestors(ancestors);
        operations.save(child);
    }

    private void buildCategoryAncestorsFull(Category category) {
        //a root, no need to add ancestors
        if (category.getParentId() == null)
            return;
        List<Category> ancestors = new ArrayList<>();
        Query childQuery =  RepositoryUtils.simpleQuery(QueryField.ID, category.getId());
        category = operations.findOne(childQuery, Category.class);
        Query parentQuery = RepositoryUtils.simpleQuery(QueryField.ID, category.getParentId());
        Category parent = operations.findOne(parentQuery, Category.class);
        while (parent != null) {
            ancestors.add(parent);
            parentQuery =  RepositoryUtils.simpleQuery(QueryField.ID, parent.getParentId());
            parent = operations.findOne(parentQuery, Category.class);
        }
        category.setAncestors(ancestors);
        operations.save(category);
    }

}
