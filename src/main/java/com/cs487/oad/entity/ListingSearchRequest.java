package com.cs487.oad.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by alexanderlerma on 11/25/16.
 */
public class ListingSearchRequest {
    private final String city;
    private final String neighborhood;
    private final String category;
    private final String subcategory;

    public ListingSearchRequest(String city, String neighborhood, String category, String subcategory) {
        this.city = city;
        this.neighborhood = neighborhood;
        this.category = category;
        this.subcategory = subcategory;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getSubcategory() {
        return subcategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("city", city)
                .append("neighborhood", neighborhood)
                .append("category", category)
                .toString();
    }
}
