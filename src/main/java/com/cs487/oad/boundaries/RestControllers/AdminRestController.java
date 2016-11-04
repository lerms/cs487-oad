//package com.cs487.oad.boundaries.RestControllers;
//
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.cs487.oad.entity.Category;
//import com.cs487.oad.entity.Listing;
//import com.cs487.oad.entity.SubCategory;
//import com.cs487.oad.interactors.CategoryInteractor;
//import com.cs487.oad.interactors.ListingInteractor;
//import org.springframework.web.bind.annotation.*;
//
//import java.com.cs487.oad.util.ArrayList;
//import java.com.cs487.oad.util.List;
//
//
//
///**
// * Created by Jeannius on 10/22/2016.
// */
//@RestController
//@RequestMapping("/admin")
//public class AdminRestController extends AbstractRestController{
//
//
//    public static final String NAME = "name";
//    public static final String DESCRIPTION = "description";
//    public static final String PRICE = "price";
//    public static final String ADDRESS = "address";
//    public static final String PHONE = "phone";
//    public static final String CATEGORY = "category";
//    public static final String FEATUR_TYPE = "featurType";
//    public static final String WEBSITE = "website";
//    public static final String SUBCATEGORIES = "subcategories";
//
//    private ListingInteractor listingInteractor = new ListingInteractor();
//    private CategoryInteractor categoryInteractor = new CategoryInteractor();
//
//    @PutMapping(value = "/listing")
//    public @ResponseBody String addListing(@RequestBody String json){
//
//        JsonObject object = getJsonObjectFromString(json);
//
//        System.out.println(object);
//        Listing listing = createListingFromJsonObject(object);
//        listingInteractor.addListing(listing);
//
//        return "Listing Has Been Created!";
//    }
//
//
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
//
////
////    @PutMapping("/category")
////    public @ResponseBody String addCategory(@RequestBody String json){
////        JsonObject  jsonObject = getJsonObjectFromString(json);
////
////        Category category = createCategoryFromJsonObject(jsonObject);
////        List<SubCategory>  subs = createSubcategoryListFromJsonObject(jsonObject);
////        categoryInteractor.add(category,subs);
////        return "Category Has Been Created!";
////    }
//
//
//        private List<SubCategory> createSubcategoryListFromJsonObject(JsonObject jsonObject) {
//        List<SubCategory> result = new ArrayList<>();
//        for(JsonElement element: jsonObject.getAsJsonArray(SUBCATEGORIES)){
//            result.add(new SubCategory(element.toString()));
//        }
//        return result;
//    }
//
//
//}
