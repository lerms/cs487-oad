package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by alexanderlerma on 11/11/16.
 */
public class CategoryDTO {
    private final String name;
    private final List<String> subcategories;

    public CategoryDTO(String name, List<String> subcategories) {
        this.name = name;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("subcategories", subcategories)
                .toString();
    }
}
