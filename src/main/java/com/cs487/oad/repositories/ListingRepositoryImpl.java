package com.cs487.oad.repositories;

import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.entity.ListingSearchRequest;
import com.cs487.oad.util.RepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        Query query = new Query();
        if (listingSearchRequest.getBusiness() != null) {
            query.addCriteria(Criteria.where("advertiser.name").is(listingSearchRequest.getBusiness()));
        }
        if (listingSearchRequest.getCategory() != null) {
            final String sluggedCategory = RepositoryUtils.toSluggedString(listingSearchRequest.getCategory());
            if (listingSearchRequest.getSubcategory() != null) {
                query.addCriteria(Criteria
                        .where("category.slug")
                        .is(sluggedCategory)
                        .orOperator(Criteria
                                .where("category.parent")
                                .is(sluggedCategory)));
            } else {
                query.addCriteria(Criteria.where("category.slug").is(sluggedCategory));
            }
        }
        return mongoOperations.find(query, Listing.class);
    }

    @Override
    public List<Listing> findByCategoryAndFeatureType(String categorySlug, FeatureType featureType) {
        Query query = Query.query(Criteria
                .where("category.slug")
                .is(categorySlug)
                .andOperator(Criteria
                        .where("featureType")
                        .is(featureType)));
        return mongoOperations.find(query, Listing.class);
    }
}
