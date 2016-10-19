package mongo.controllers;

import entity.Category;
import mongo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
