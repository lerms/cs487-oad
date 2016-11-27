package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/4/16.
 */
@Repository
public interface ListingRepository extends MongoRepository<Listing, String> , ListingRepositoryCustom {

    List<Listing> findByFeatureType(FeatureType featureType);

    List<Listing> findByCategory(Category category);

    Listing findById(String id);

    Listing deleteById(String id);
}
