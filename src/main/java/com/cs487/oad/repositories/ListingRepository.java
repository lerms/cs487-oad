package com.cs487.oad.repositories;
import com.cs487.oad.entity.Listing;
import org.bson.types.ObjectId;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by alexanderlerma on 10/4/16.
 */
@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {

    List<Listing> findByName(String name);
    List<Listing> findByCity(String city);
    List<Listing> findByPhone(String phone);
    List<Listing> findByFeatureType(String type);
    List<Listing> findByCategoryId(String id);
    Listing findById(String id);
    Listing deleteById(String id);


}
