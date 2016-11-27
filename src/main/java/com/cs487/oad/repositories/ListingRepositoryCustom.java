package com.cs487.oad.repositories;

import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.entity.ListingSearchRequest;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by alexanderlerma on 11/25/16.
 */
@NoRepositoryBean
public interface ListingRepositoryCustom {

    List<Listing> search(ListingSearchRequest listingSearchRequest);
    List<Listing> findByCategoryAndFeatureType(String categorySlug, FeatureType featureType);
}
