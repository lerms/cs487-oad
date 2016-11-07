package com.cs487.oad.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by alexanderlerma on 10/17/16.
 */
@Document(collection = "category")
public class Category implements Serializable {
    @Id
    private ObjectId id;
    private ObjectId parentId;
    private String name;
    private String slug;
    private List<Category> ancestors;

    public Category() {}


    public Category(String name, ObjectId parentId, String slug, List<Category> ancestors) {
        this.name = name;
        this.parentId = parentId;
        this.slug = slug;
        this.ancestors = ancestors;
    }

    public Category(String name, ObjectId parent, String slug) {
        this(name, parent, slug, new ArrayList<>());
    }

    public void addAncestorCategory(Category category) {
        if (category != null)
            ancestors.add(category);
    }

    public void addAllAncestorCategories(List<Category> ancestors) {
        if (ancestors != null)
            ancestors.forEach(this::addAncestorCategory);
    }

    public void rebuildAncestors(List<Category> ancestors) {
        this.ancestors = new ArrayList<>();
        ancestors.forEach(this.ancestors::add);
    }

    public List<Category> getAncestors() {
        List<Category> ancestorCopy = new ArrayList<>(ancestors.size());
        ancestors.forEach(ancestorCopy::add);
        return ancestorCopy;
    }

    public ObjectId getId() {
        return id;
    }

    public ObjectId getParentId() {
        return parentId;
    }

    public String getName(){
        return name;
    }

}
