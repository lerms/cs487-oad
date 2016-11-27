package com.cs487.oad.repositories;

import com.cs487.oad.entity.Advertiser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by alexanderlerma on 10/16/16.
 */
@Repository
public interface AdvertiserRepository extends MongoRepository<Advertiser, String> {

    Advertiser findByEmail(String email);
    Advertiser findByName(String name);
    Advertiser findByNameIgnoreCase(String name);
    Advertiser findBySlug(String slug);

}
