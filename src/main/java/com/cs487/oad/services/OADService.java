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
    List<Listing> findListings();
    List<Category> findCategories();
    List<Advertiser> findAdvertisers();
}
