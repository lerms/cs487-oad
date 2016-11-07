package com.cs487.oad.controllers;
import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.services.OADService;
import com.cs487.oad.entity.Listing;
import com.google.common.base.Preconditions;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * Created by Jeannius on 10/22/2016.
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController extends OADRestController {


    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String CATEGORY = "category";
    public static final String FEATUR_TYPE = "featurType";
    public static final String WEBSITE = "website";
    public static final String SUBCATEGORIES = "subcategories";
//
//    private ListingInteractor listingInteractor = new ListingInteractor();
//    private CategoryInteractor categoryInteractor = new CategoryInteractor();

    public AdminRestController(OADService oadService) {
        super(oadService);
    }

    @GetMapping("/listing")
    public List<Listing> getAllListings() {
        return oadService.findListings();
    }


    @PutMapping("/listing")
    public @ResponseBody String putListing(@RequestBody String json){
        Preconditions.checkNotNull(json);
        Listing listing = gson.fromJson(json, Listing.class);
        oadService.saveListing(listing);
        return "Listing Has Been Created!";
    }

    @PutMapping("/category")
    public @ResponseBody String putCategory(@RequestBody String json) {
        Preconditions.checkNotNull(json);
        Category category = gson.fromJson(json, Category.class);
        Preconditions.checkNotNull(json);
        oadService.saveCategory(category);
        return "Category Has Been Created!";
    }

    @PutMapping("/advertiser")
    public @ResponseBody String putAdvertiser(@RequestBody String json) {
        Preconditions.checkNotNull(json);
        Advertiser advertiser = gson.fromJson(json, Advertiser.class);
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
