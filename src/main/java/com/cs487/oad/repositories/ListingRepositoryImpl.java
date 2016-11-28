package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.entity.ListingSearchRequest;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

        List<Listing> filterListings = mongoOperations.findAll(Listing.class);


        if (listingSearchRequest.getQuery() != null) {
            filterListings = querySearchFilter(listingSearchRequest.getQuery(), filterListings);
        }


        if (listingSearchRequest.getCity() != null) {
            filterListings = filterListings
                    .stream()
                    .filter(listing ->
                            listing.getLocation().getCity().toLowerCase().contains(listingSearchRequest.getCity().toLowerCase()))
                    .collect(Collectors.toList());

        }

        if (listingSearchRequest.getNeighborhood() != null) {
            filterListings = filterListings
                    .stream()
                    .filter(listing ->
                            listing.getLocation().getNeighborhood().toLowerCase().contains(listingSearchRequest.getNeighborhood().toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (listingSearchRequest.getCategory() != null) {
            filterListings = filterListings
                    .stream()
                    .filter(listing -> listing.getCategory().getName()
                            .equalsIgnoreCase(listingSearchRequest.getCategory()))
                    .collect(Collectors.toList());

            if (listingSearchRequest.getSubcategory() != null) {
                filterListings = filterListings
                        .stream()
                        .filter(listing -> listing.getSubcategories()
                                .stream()
                                .anyMatch(subcat -> subcat.getName()
                                        .equalsIgnoreCase(listingSearchRequest.getSubcategory())))
                        .collect(Collectors.toList());
            }
        }
        return filterListings;
    }

    private List<Listing> querySearchFilter(String query, List<Listing> listings) {
        if (query == null)
            return Lists.newArrayList();

        //search name, category, subcategory for the query
        final String queryLowercase = query.toLowerCase();

        List<Listing> filtered = listings.stream()
                .filter(listing -> {
                    boolean containsListingName = listing.getName().toLowerCase().contains(queryLowercase);

                    boolean containsCategory = listing.getCategory().getName().toLowerCase().contains(queryLowercase);

                    boolean containsSubcategory = listing.getSubcategories()
                            .stream()
                            .map(Category::getName)
                            .map(String::toLowerCase)
                            .anyMatch(name -> name.contains(queryLowercase));

                    return containsListingName || containsCategory || containsSubcategory;

                })
                .collect(Collectors.toList());

        return filtered;
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
