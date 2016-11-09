package com.cs487.oad.controllers;
import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.interactors.CategoryInteractor;
import com.cs487.oad.interactors.ListingInteractor;
import com.cs487.oad.services.OADService;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.util.RepositoryUtils;
import com.google.common.base.Preconditions;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * Created by Jeannius on 10/22/2016.
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController extends OADRestController {


    private ListingInteractor listingInteractor = new ListingInteractor();
    private CategoryInteractor categoryInteractor = new CategoryInteractor();

    public AdminRestController(OADService oadService) {
        super(oadService);
    }

    @GetMapping("/listing")
    public @ResponseBody List<Listing> getAllListings() {
        return RepositoryUtils.checkFound(oadService.findListings());
    }

    @GetMapping("/category")
    public @ResponseBody List<Category> getAllCategories() {
        return RepositoryUtils.checkFound(oadService.findCategories());
    }

    @GetMapping("/advertiser")
    public List<Advertiser> getAllAdvertisers() {
        return RepositoryUtils.checkFound(oadService.findAdvertisers());
    }

    @PutMapping("/listing")
    public @ResponseBody String putListing(@RequestBody Listing listing) {
        Preconditions.checkNotNull(listing);
        oadService.saveListing(listing);
        return "Listing Has Been Created!";
    }

    @PutMapping("/category")
    public @ResponseBody String putCategory(@RequestBody Category category) {
        Preconditions.checkNotNull(category);
        oadService.saveCategory(category);
        return "Listing Has Been Created!";
    }


    @PutMapping("/advertiser")
    public @ResponseBody String putAdvertiser(@RequestBody Advertiser advertiser) {
        Preconditions.checkNotNull(advertiser);
        oadService.saveAdvertiser(advertiser);
        return "Advertiser Has Been Created";
    }



//    private Listing createListingFromJsonObject(JsonObject object){
//        Listing listing = new Listing();
//        listing.setName(getStringFromJsonObject(object, NAME));
//        listing.setDescription(getStringFromJsonObject(object, DESCRIPTION));
//        listing.setPrice(getDoubleFromJsonObject(object, PRICE));
//        listing.setAddress(getStringFromJsonObject(object, ADDRESS));
//        listing.setPhoneNumber(getStringFromJsonObject(object, PHONE));
//        listing.setCategory(getStringFromJsonObject(object, CATEGORY));
//        listing.setFeatureType(getStringFromJsonObject(object, FEATUR_TYPE));
//        listing.setWebsite(getStringFromJsonObject(object, WEBSITE));
//        return listing;
//    }
//
}
