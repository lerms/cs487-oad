package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {

    private CategoryRepository categoryRepository;
    private AdvertiserRepository advertiserRepository;
    private ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository, ListingRepository listingRepository) {
        this.categoryRepository = categoryRepository;
        this.advertiserRepository = advertiserRepository;
        this.listingRepository = listingRepository;
    }


    @Override
    public void saveListing(Listing listing) {

    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public void saveAdvertiser(Advertiser advertiser) {

    }

    @Override
    public void deleteListing(Listing listing) {

    }

    @Override
    public void deleteCategory(Category category) {

    }

    @Override
    public void deleteAdvertiser(Advertiser advertiser) {

    }

    @Override
    public List<Listing> findListings() {
        return null;
    }

    @Override
    public List<Category> findCategories() {
        return null;
    }

    @Override
    public List<Advertiser> findAdvertisers() {
        return null;
    }
}
