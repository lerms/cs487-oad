package com.cs487.oad.repositories;

import com.cs487.oad.entity.Advertiser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/16/16.
 */
public interface AdvertiserRepository extends MongoRepository<Advertiser, String> {

    List<Advertiser> findByDescription(String name);

}
