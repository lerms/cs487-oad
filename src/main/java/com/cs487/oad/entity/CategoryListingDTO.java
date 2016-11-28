package com.cs487.oad.entity;

import java.util.List;

/**
 * Created by alexanderlerma on 11/27/16.
 */
public class CategoryListingDTO {
    private final String name;
    private final ListingDTO categoryFeaturedListing;
    private final List<SubcategoryListingDTO> subcategories;

    public CategoryListingDTO(String name, ListingDTO categoryFeaturedListing, List<SubcategoryListingDTO> subcategories) {
        this.name = name;
        this.categoryFeaturedListing = categoryFeaturedListing;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public ListingDTO getCategoryFeaturedListing() {
        return categoryFeaturedListing;
    }

    public List<SubcategoryListingDTO> getSubcategories() {
        return subcategories;
    }
}
