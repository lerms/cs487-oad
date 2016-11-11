package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import com.cs487.oad.util.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {
    private final CategoryRepository categoryRepository;
    private final AdvertiserRepository advertiserRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository,
                          ListingRepository listingRepository) {
        this.categoryRepository = categoryRepository;
        this.advertiserRepository = advertiserRepository;
        this.listingRepository = listingRepository;
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


    public void updateListingName(String id, String newName) {
        Listing listing = RepositoryUtils.checkFound(listingRepository.findById(id));
        listing.setName(newName);
        listingRepository.save(listing);
    }

    @Override
    public void updateCategoryName(String name, String newName) {
        categoryRepository.updateName(name, newName);
    }

    @Override
    public void updateCategorySlug(String slug, String newSlug) {
        categoryRepository.updateSlug(slug, newSlug);
    }

    @Override
    public void updateCategoryAncestors(String id, List<Category> ancestors) {
        categoryRepository.updateAncestors(id, ancestors);
    }

    @Override
    public void updateAdvertiserName(String email, String newName) {
        Advertiser advertiser = RepositoryUtils.checkFound(advertiserRepository.findByEmail(email));
        advertiser.setName(newName);
        advertiserRepository.save(advertiser);
    }

    @Override
    public List<Listing> findAllListings() {
        return RepositoryUtils.checkFound(listingRepository.findAll());
    }

    @Override
    public List<Category> findAllCategories() {
        return RepositoryUtils.checkFound(categoryRepository.findAll());
    }

    @Override
    public List<Advertiser> findAllAdvertisers() {
        return RepositoryUtils.checkFound(advertiserRepository.findAll());
    }

    @Override
    public Category findCategoryByName(String name) {
        return RepositoryUtils.checkFound(categoryRepository.findByName(name));
    }

    @Override
    public Category findCategoryBySlug(String slug) {
        return RepositoryUtils.checkFound(categoryRepository.findByName(slug));
    }

    public void emptyCollectionsForTesting() {
        advertiserRepository.deleteAll();
        categoryRepository.deleteAll();
        listingRepository.deleteAll();
    }

}