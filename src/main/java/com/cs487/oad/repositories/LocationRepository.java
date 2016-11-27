package com.cs487.oad.repositories;

import com.cs487.oad.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexanderlerma on 11/26/16.
 */
@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByCity(String city);
    List<Location> findByNeighborhood(String area);
    Location findById(String id);
    Location findByCityAndNeighborhood(String city, String area);
}
