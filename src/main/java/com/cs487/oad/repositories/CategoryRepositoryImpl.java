package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import com.cs487.oad.util.QueryField;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public void updateName(String slug, String newName) {
        Query query = RepositoryUtils.categorySlugQuery(slug);
        Category toUpdate = RepositoryUtils.checkFound(operations.findOne(query, Category.class));
        toUpdate.setName(newName);
        operations.save(toUpdate);
        updateDescendants(toUpdate.getId(), QueryField.NAME, newName);
    }

    @Override
    public void updateParent(String slug, String parentSlug) {
        Query slugQuery = RepositoryUtils.categorySlugQuery(slug);
        Query parentSlugQuery = RepositoryUtils.categorySlugQuery(parentSlug);
        Category toUpdate = RepositoryUtils.checkFound(operations.findOne(slugQuery, Category.class));
        Category parent = RepositoryUtils.checkFound(operations.findOne(parentSlugQuery, Category.class));
        toUpdate.setParentId(parent.getParentId());
        operations.save(toUpdate);
        rebuildDescendants(toUpdate.getId());
    }

    @Override
    public void updateSlug(String slug, String newSlug) {
        Query query = RepositoryUtils.simpleQuery(QueryField.SLUG, slug);
        Category toUpdate = RepositoryUtils.checkFound(operations.findOne(query, Category.class));
        toUpdate.setSlug(newSlug);
        updateDescendants(toUpdate.getId(), QueryField.SLUG, newSlug);
    }

    @Override
    public void addCategoryAncestor(String slug, String ancestorSlug) {
        Category update = RepositoryUtils.checkFound(operations.findOne(RepositoryUtils.categorySlugQuery(slug), Category.class));
        update.getAncestors().forEach(x -> {
            if(x.getSlug().equals(ancestorSlug))
                return;
        });
        Category ancestor = RepositoryUtils.checkFound(operations.findOne(RepositoryUtils.categorySlugQuery(ancestorSlug), Category.class));
        update.addAncestorCategory(ancestor);
        updateAncestors(slug, update.getAncestors());
    }


    @Override
    public void updateAncestors(String slug, List<Category> newAncestors) {
        Preconditions.checkContentsNotNull(Arrays.asList(slug, newAncestors));
        Query query = RepositoryUtils.categorySlugQuery(slug);
        Category category = operations.findOne(query, Category.class);
        category.setAncestors(newAncestors);
        operations.save(category);
        rebuildDescendants(category.getId());
    }


    @Override
    public Category insertCategory(Category category) {
        Preconditions.checkNotNull(category);
        Preconditions.checkNotNull(category.getSlug());
        Query slugQuery = RepositoryUtils.categorySlugQuery(category.getSlug());
        operations.insert(category);
        category = operations.findOne(slugQuery, Category.class);
        if (category.getParentId() == null)
            return category;
        buildCategoryAncestors(category.getId(), category.getParentId());
        category = operations.findOne(RepositoryUtils.categorySlugQuery(category.getSlug()), Category.class);
        return category;
    }


    @Override
    public void deleteCategory(String slug) {
        Preconditions.checkNotNull(slug);
        Category category = RepositoryUtils
                .checkFound(operations.findOne(RepositoryUtils.categorySlugQuery(slug), Category.class));
        operations.remove(RepositoryUtils.categorySlugQuery(slug), Category.class);
        rebuildDescendants(category.getId());
    }

    private void rebuildDescendants(String id) {
        Query query = Query.query(Criteria
                .where(QueryField.ANCESTORS.toString() + "." + QueryField.ID.toString())
                .is(id)
                .andOperator(Criteria
                        .where(QueryField.PARENT_ID.toString())
                        .exists(true)));
        List<Category> descendants = RepositoryUtils.checkFound(operations.find(query, Category.class));
        descendants.forEach(cat -> buildCategoryAncestorsFull(cat.getId(), cat.getParentId()));
    }

    private void updateDescendants(String id, QueryField field, String value) {
        Query query = Query.query(Criteria
                .where(QueryField.ANCESTORS.toString() + "." + QueryField.ID.toString())
                .is(id)
                .andOperator(Criteria
                        .where(QueryField.PARENT_ID.toString())
                        .exists(true)));
        Update update = new Update().set(QueryField.ANCESTORS.toString() + ".$." + field.toString(), value);
        operations.updateMulti(query, update, Category.class);
    }


    private void buildCategoryAncestors(String id, String parentId) {
        Query idQuery = RepositoryUtils.categoryIdQuery(id);
        Category update = RepositoryUtils.checkFound(operations.findOne(idQuery, Category.class));
        Query parentIdQuery = RepositoryUtils.categoryIdQuery(parentId);
        Category parent = RepositoryUtils.checkFound(operations.findOne(parentIdQuery, Category.class));
        List<Category> ancestors = new ArrayList<>();
        ancestors.add(parent);
        ancestors.addAll(parent.getAncestors());
        update.setAncestors(ancestors);
        operations.save(update);
    }

    private void buildCategoryAncestorsFull(String id, String parentId) {
        List<Category> ancestors = new ArrayList<>();
        while (parentId != null) {
            Category parent = operations.findOne(RepositoryUtils.categoryIdQuery(parentId), Category.class);
            parentId = parent.getParentId();
            ancestors.add(parent);
        }
        Query idQuery = RepositoryUtils.categoryIdQuery(id);
        Category toUpdate = operations.findOne(idQuery, Category.class);
        toUpdate.setAncestors(ancestors);
        operations.save(toUpdate);
    }

}
