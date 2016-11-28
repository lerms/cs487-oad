package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by alexanderlerma on 10/17/16.
 */
@Document(collection = "category")
public class Category extends OADEntity implements Comparable<Category> {

    private String parentId;
    @Indexed(unique = true)
    private String name;
    @Indexed(unique = true)
    private String slug;
    @DBRef
    private List<Category> ancestors;

    public Category() {
    }

    public Category(String name, String parentId, String slug, List<Category> ancestors) {
        this.name = name;
        this.parentId = parentId;
        this.slug = slug;
        this.ancestors = ancestors;
    }

    public Category(String name, String parentId, String slug) {
        this(name, parentId, slug, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getId() {
        return id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void addAncestorCategory(Category category) {
        if (category != null)
            ancestors.add(category);
    }

    public void setAncestors(List<Category> ancestors) {
        this.ancestors = new ArrayList<>();
        ancestors.forEach(this.ancestors::add);
    }

    public List<Category> getAncestors() {
        List<Category> ancestorCopy = new ArrayList<>(ancestors.size());
        ancestors.forEach(ancestorCopy::add);
        return ancestorCopy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("parentId", parentId)
                .append("name", name)
                .append("slug", slug)
                .append("ancestors", ancestors)
                .toString();
    }

    @Override
    public int compareTo(Category o) {
        if(o.getSlug().equals(slug))
            return 0;
        if (o.getSlug().compareTo(slug) < 0)
            return -1;
        return 1;
    }
}
