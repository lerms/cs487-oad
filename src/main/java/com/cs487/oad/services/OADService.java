package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;


import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */

public interface OADService {

    void saveListing(Listing listing);
    void saveCategory(Category category);
    void saveAdvertiser(Advertiser advertiser);
    void deleteListing(Listing listing);
    void deleteCategory(Category category);
    void deleteAdvertiser(Advertiser advertiser);
    void updateListingName(String name, String newName);
    void updateCategoryName(String name, String newName);
    void updateCategorySlug(String slug, String newSlug);
    void updateCategoryAncestors(String id, List<Category> ancestors);
    void updateAdvertiserName(String name, String newName);
    List<Listing> findAllListings();
    List<Category> findAllCategories();
    List<Advertiser> findAllAdvertisers();
    Category findCategoryByName(String name);
    Category findCategoryBySlug(String slug);
    void emptyCollectionsForTesting();
}
