package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.entity.ListingSearchRequest;
import com.cs487.oad.util.QueryField;
import com.cs487.oad.util.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alexanderlerma on 11/25/16.
 */
@Repository
public class ListingRepositoryImpl implements ListingRepositoryCustom {

    private final MongoOperations mongoOperations;

    @Autowired
    public ListingRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Listing> search(ListingSearchRequest listingSearchRequest) {
        List<Listing> searchListings = mongoOperations.findAll(Listing.class);
        Query query = new Query();

        if (listingSearchRequest.getBusiness() != null) {
            searchListings = searchListings
                    .stream()
                    .filter(listing ->
                            listing.getAdvertiser().getName().equalsIgnoreCase(listingSearchRequest.getBusiness()))
                    .collect(Collectors.toList());
        }

        if (listingSearchRequest.getCategory() != null) {
            final String sluggedCategory = RepositoryUtils.toSluggedString(listingSearchRequest.getCategory());

            searchListings = searchListings
                    .stream()
                    .filter(listing -> listing.getCategory().getName()
                            .equalsIgnoreCase(listingSearchRequest.getCategory()))
                    .collect(Collectors.toList());

            if (listingSearchRequest.getSubcategory() != null) {
                searchListings = searchListings
                        .stream()
                        .filter(listing -> listing.getSubcategories()
                                .stream()
                                .anyMatch(subcat -> subcat.getName()
                                        .equalsIgnoreCase(listingSearchRequest.getSubcategory())))
                        .collect(Collectors.toList());
            }
        }
        return searchListings;
    }

    @Override
    public List<Listing> findBySubCategory(String subcategoryName) {
        List<Listing> allListings = mongoOperations.findAll(Listing.class);
        return allListings
                .stream()
                .filter(listing -> listing.getSubcategories()
                        .stream()
                        .anyMatch(subcat -> subcat.getName()
                                .equalsIgnoreCase(subcategoryName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Listing> findByCategory(String categoryName) {
        List<Listing> allListings = mongoOperations.findAll(Listing.class);
        return allListings
                .stream()
                .filter(listing -> listing.getCategory().getName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
    }


}
