package mongo.repositories;

import entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/19/16.
 */
public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByName(String name);
    List<Category> findBySlug(String slug);
    String deleteBySlug(String slug);

}
