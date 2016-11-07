package com.cs487.oad.services;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.repositories.CategoryRepository;
import com.cs487.oad.repositories.ListingRepository;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderlerma on 11/3/16.
 */
@Service
public class OADServiceImpl implements OADService {
    private final MongoTemplate mongoTemplate;
    private final CategoryRepository categoryRepository;
    private final AdvertiserRepository advertiserRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public OADServiceImpl(CategoryRepository categoryRepository, AdvertiserRepository advertiserRepository,
                          ListingRepository listingRepository, MongoTemplate mongoTemplate) {
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
        categoryRepository.save(category);
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
        categoryRepository.delete(category);
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


    private void buildCategoryAncestors(String id, String parentId) {
        Category child =  categoryRepository.findById(id);
        Category parent = categoryRepository.findById(parentId);
        List<Category> ancestors = new ArrayList<>();
        ancestors.add(parent);
        ancestors.addAll(parent.getAncestors());
        child.setAncestors(ancestors);
        saveCategory(child);
    }

    private void buildCategoryAncestorsFull(String id, String parentId) {
        List<Category> ancestors = new ArrayList<>();
        Category updateCategory = categoryRepository.findById(id);
        Category parent;
        while (parentId != null) {
            parent = categoryRepository.findById(parentId);
            parentId = parent.getParentId();
            ancestors.add(parent);
        }
        updateCategory.setAncestors(ancestors);
        saveCategory(updateCategory);
    }

    @Override
    public Category createCategory(String name, String slug, String parent) {
        Category category = new Category(name, parent, slug);
        category = categoryRepository.insert(category);
        if(parent != null)
            buildCategoryAncestors(category.getId(), parent);
            category = categoryRepository.findById(category.getId());
        return category;
    }

    public Pair<Query, Update> customQueryUpdate(String queryField, String queryValue, String updateField, String updateValue) {
        Query query = new Query();
        query.addCriteria(Criteria.where(queryField).is(queryValue));
        Update update = new Update();
        update.set(updateField, updateValue);
        return Pair.of(query, update);
    }

}
