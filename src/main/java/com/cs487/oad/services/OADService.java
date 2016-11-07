package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;

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
    void updateListing(Query query, Update update);
    void updateCategory(Query query, Update update);
    void updateAdvertiser(Query query, Update update);
    Category createCategory(String name, String slug, String parentId);
    List<Listing> findListings();
    List<Category> findCategories();
    List<Advertiser> findAdvertisers();
    public Pair<Query, Update> customQueryUpdate(String queryField, String queryValue, String updateField, String updateValue);
}
