package com.cs487.oad.controllers;

import com.cs487.oad.entity.Category;
import com.cs487.oad.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderlerma on 10/19/16.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categories;

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categories.findAll();
    }

    @RequestMapping(value = "/{slug}", method = RequestMethod.GET)
    public Category getCategoryBySlug(@PathVariable("slug") String slug) {
        return categories.findOne(slug);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Category getCategoryByName(@PathVariable("name") String name) {
        return categories.findOne(name);
    }

    public void renameCategory(ObjectId id, String newName) {
        Category category = categories.findById(id);
        Update update = new Update().set("name", newName);
    }

    public void buildAncestors(ObjectId id, ObjectId parentId) {
        Category child = categories.findById(id);
        Category parent = categories.findById(parentId);
        List<Category> ancestors = new ArrayList<>();
        ancestors.add(parent);
        ancestors.addAll(parent.getAncestors());
        child.rebuildAncestors(ancestors);
        categories.save(child);
    }

    public void buildAncestorsFull(ObjectId id, ObjectId parentId) {
        List<Category> ancestors = new ArrayList<>();
        Category updateCategory = categories.findById(id);
        Category parent;
        while (parentId != null) {
            parent = categories.findById(parentId);
            parentId = parent.getParentId();
            ancestors.add(parent);
        }
        updateCategory.rebuildAncestors(ancestors);
        categories.save(updateCategory);
    }

    public void createCategory(String name, String slug, ObjectId parent) {
        Category category = new Category(name, parent, slug);
        category = categories.insert(category);
        buildAncestors(category.getId(), parent);
    }










}
