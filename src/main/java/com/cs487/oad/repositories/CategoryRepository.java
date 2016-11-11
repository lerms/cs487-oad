package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/19/16.
 */
@Repository
public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepositoryCustom {
    Category findByName(String name);
    Category findById(String id);
    Category findBySlug(String slug);
    List<Category> findByParentId(String parentId);
}
