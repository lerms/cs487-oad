package com.cs487.oad.services;

import com.cs487.oad.entity.*;

import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */

public interface OADService {

    void saveListing(ListingDTO listing);
    void saveCategory(CategoryDTO category);
    void saveCategory(Category category);
    void saveCategories(List<CategoryDTO> categories);
    void saveAdvertiser(AdvertiserDTO advertiserDto);
    void deleteListing(Listing listing);
    void deleteCategory(CategoryDTO category);
    void deleteAdvertiser(Advertiser advertiser);
    void updateListingName(String name, String newName);
    void updateCategoryName(String name, String newName);
    void updateCategorySlug(String slug, String newSlug);
    void updateAdvertiserName(String name, String newName);
    List<Listing> findAllListings();
    List<ListingDTO> findAllListingsAsDtos();
    List<Category> findAllCategories();
    List<Advertiser> findAllAdvertisers();
    List<CategoryDTO> findAllCategoriesAsDtos();
    Category findCategoryByName(String name);
    CategoryDTO findCategoryBySlug(String slug);
    Category findCategoryById(String id);
    void emptyCollectionsForTesting();
}