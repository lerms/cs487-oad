package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by alexanderlerma on 11/8/16.
 */
public interface CustomCategoryRepository  {
    void updateName(String name, String newName);
    void updateSlug(String slug, String newSlug);
    void updateAncestors(String id, List<Category> newAncestors);
    void saveCategory(Category category);
    void deleteCategory(Category category);
}
