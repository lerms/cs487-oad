package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {
    private final MongoOperations mongoTemplate;
    private final CategoryRepository categoryRepository;
    private final AdvertiserRepository advertiserRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository,
                          ListingRepository listingRepository, MongoOperations mongoTemplate) {
        this.categoryRepository = categoryRepository;
        this.advertiserRepository = advertiserRepository;
        this.listingRepository = listingRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.saveCategory(category);
    }

    @Override
    public void saveAdvertiser(Advertiser advertiser) {
        advertiserRepository.save(advertiser);
    }


    @Override
    public void deleteListing(Listing listing) {
        listingRepository.delete(listing);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.deleteCategory(category);
    }

    @Override
    public void deleteAdvertiser(Advertiser advertiser) {
        advertiserRepository.delete(advertiser);
    }


    public void updateListing(Query query, Update update) {
        mongoTemplate.updateFirst(query, update, Listing.class);
    }

    @Override
    public void updateCategory(Query query, Update update) {
        mongoTemplate.updateFirst(query, update, Category.class);
    }

    @Override
    public void updateAdvertiser(Query query, Update update) {
        mongoTemplate.updateFirst(query, update, Advertiser.class);
    }


    @Override
    public List<Listing> findListings() {
        return listingRepository.findAll();
    }

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Advertiser> findAdvertisers() {
        return advertiserRepository.findAll();
    }


    public void emptyCollectionsForTesting() {
        advertiserRepository.deleteAll();
        categoryRepository.deleteAll();
        listingRepository.deleteAll();
    }

}
