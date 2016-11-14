package com.cs487.oad.controllers;
import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.CategoryDTO;
import com.cs487.oad.services.OADService;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * Created by Jeannius on 10/22/2016.
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController extends OADRestController {

    @Autowired
    public AdminRestController(OADService oadService) {
        super(oadService);
    }

    @GetMapping("/listing")
    public @ResponseBody List<Listing> getAllListings() {
        return RepositoryUtils.checkFound(oadService.findAllListings());
    }

    @GetMapping("/category")
    public @ResponseBody List<Category> getAllCategories() {
        return RepositoryUtils.checkFound(oadService.findAllCategories());
    }

    @GetMapping("/category/{slug}")
    public @ResponseBody Category getCategoryBySlug(@PathVariable String slug) {
        return RepositoryUtils.checkFound(oadService.findCategoryBySlug(slug));
    }

    @GetMapping("/advertiser")
    public List<Advertiser> getAllAdvertisers() {
        return RepositoryUtils.checkFound(oadService.findAllAdvertisers());
    }

    @PutMapping("/listing")
    public @ResponseBody String putListing(@RequestBody Listing listing) {
        Preconditions.checkNotNull(listing);
        oadService.saveListing(listing);
        return "Listing Has Been Created!";
    }

    @PutMapping("/category")
    public @ResponseBody String putCategory(@RequestBody CategoryDTO categoryDTO) {
        Preconditions.checkNotNull(categoryDTO);
        oadService.saveCategory(categoryDTO);
        return "Category has been created!";

    }


    @PutMapping("/advertiser")
    public @ResponseBody String putAdvertiser(@RequestBody Advertiser advertiser) {
        Preconditions.checkNotNull(advertiser);
        oadService.saveAdvertiser(advertiser);
        return "Advertiser Has Been Created";
    }
}
