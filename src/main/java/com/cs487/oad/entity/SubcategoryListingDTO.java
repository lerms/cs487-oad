package com.cs487.oad.entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alexanderlerma on 11/27/16.
 */
public class SubcategoryListingDTO {
    private final String name;
    private final ListingDTO subcategoryFeaturedListing;
    private final List<ListingDTO> listings;

    public SubcategoryListingDTO(String name, ListingDTO subcategoryFeaturedListing, List<ListingDTO> listings) {
        this.name = name;
        this.subcategoryFeaturedListing = subcategoryFeaturedListing;
        this.listings = listings;
    }

    public String getName() {
        return name;
    }

    public ListingDTO getSubcategoryFeaturedListing() {
        return subcategoryFeaturedListing;
    }

    public List<ListingDTO> getListings() {
        return Lists.newArrayList(listings);
    }
}
