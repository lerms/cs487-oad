package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by alexanderlerma on 11/25/16.
 */
public class ListingSearchRequest {
    private final String category;
    private final String subcategory;
    private final String business;

    public ListingSearchRequest(String category, String subcategory, String business) {
        this.category = category;
        this.subcategory = subcategory;
        this.business = business;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getBusiness() {
        return business;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("category", category)
                .append("subcategory", subcategory)
                .append("business", business)
                .toString();
    }
}
