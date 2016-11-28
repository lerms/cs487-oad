package com.cs487.oad.repositories;

import com.cs487.oad.entity.Category;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by alexanderlerma on 11/8/16.
 */
@NoRepositoryBean
interface CategoryRepositoryCustom {
    List<Category> getSubcategories(String slug);

    void updateName(String slug, String newName);

    void updateSlug(String slug, String newSlug);

    void updateAncestors(String slug, List<Category> newAncestors);

    void updateParent(String slug, String parentSlug);

    Category insertCategory(Category category);

    void deleteCategory(String slug);

    void addCategoryAncestor(String slug, String ancestorSlug);
}
