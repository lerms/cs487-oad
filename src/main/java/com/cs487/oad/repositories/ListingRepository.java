package com.cs487.oad.repositories;

import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/4/16.
 */
@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {

    List<Listing> findByName(String name);
    List<Listing> findByCity(String city);
    List<Listing> findByArea(String area);
    List<Listing> findByPhone(String phone);
    List<Listing> findByFeatureType(FeatureType featureType);
    List<Listing> findByCategory(String slug);
    Listing findById(String id);
    Listing deleteById(String id);


}
