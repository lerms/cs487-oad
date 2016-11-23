package com.cs487.oad.controllers;

import com.cs487.oad.entity.*;
import com.cs487.oad.services.OADService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
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

    @GetMapping("/")
    public String adminHome() {
        return "admin.html";
    }

    @GetMapping("/listing")
    public @ResponseBody List<Listing> getAllListings() {
        return oadService.findAllListings();
    }

    @GetMapping("/category")
    public @ResponseBody List<CategoryDTO> getAllCategories() {
        return oadService.findAllCategoriesAsDtos();
    }

    @GetMapping("/category/{slug}")
    public @ResponseBody CategoryDTO getCategoryBySlug(@PathVariable String slug) {
        return oadService.findCategoryBySlug(slug);
    }

    @GetMapping("/advertiser")
    public List<Advertiser> getAllAdvertisers() {
        return oadService.findAllAdvertisers();
    }

    @PutMapping("/listing")
    public @ResponseBody String putListing(@RequestBody ListingDTO listingDto) {
        Preconditions.checkNotNull(listingDto);
        oadService.saveListing(listingDto);
        return "Listing Has Been Created!";
    }

    @PutMapping("/category")
    public @ResponseBody String putCategory(@RequestBody CategoryDTO categoryDto) {
        Preconditions.checkNotNull(categoryDto);
        oadService.saveCategory(categoryDto);
        return "Category has been created!";

    }

    @PutMapping("/advertiser")
    public @ResponseBody String putAdvertiser(@RequestBody AdvertiserDTO advertiserDto) {
        Preconditions.checkNotNull(advertiserDto);
        oadService.saveAdvertiser(advertiserDto);
        return "Advertiser Has Been Created";
    }

    @GetMapping("/locations")
    public @ResponseBody List<LocationDTO> getLocations() {
        return Lists.newArrayList();
    }


}
