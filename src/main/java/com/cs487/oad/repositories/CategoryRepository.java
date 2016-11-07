package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/19/16.
 */
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByName(String name);
    List<Category> findBySlug(String slug);
    Category findById(ObjectId id);
    Category findByParentId(ObjectId parentId);
    String deleteBySlug(String slug);

}
