//package com.cs487.oad.boundaries.RestControllers;
//
//
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.cs487.oad.entity.Category;
//import com.cs487.oad.entity.CategorySerialize;
//import com.cs487.oad.entity.Listing;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//import java.com.cs487.oad.util.HashMap;
//import java.com.cs487.oad.util.Map;
//
//
//
///**
// * Created by Jlarrieux on 10/17/2016.
// */
//@RestController
//public class testController {
//
//
//    @GetMapping(value = "/JsonObject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Map<String, Integer> testingThis(){
//        Map<String, Integer> map = new HashMap<>();
//        map.put("fIVE", 5);
//        return map;
//    }
//
//
//    @RequestMapping(value = "/")
//    public String home(){
//        return "hello World";
//    }
//
//
//    @GetMapping(value = "/listing", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody String getListings(){
//
//        Category c = new Category("Restaurant");
////        c.add("Steak", buildListing());
////        c.add("Pizza", buildListing2());
//
//        HashMap<String, Category>  categories = new HashMap<>();
//        categories.put("categories", c);
//        Gson gson = new GsonBuilder().registerTypeAdapter(Category.class,new CategorySerialize()).create();
//        return gson.toJson(c);
//
//    }
//
//
//    private Listing buildListing(){
//        Listing l = new Listing();
//        l.setPrice(175.6);
//        l.setStartDate(LocalDate.of(2013,12,12));
//        l.setEndDate(LocalDate.of(2017,12,12));
//        l.setName("Morton's");
//        l.setAddress("1212 South Ave, Chicago, IL");
//        l.setPhoneNumber("(312) 111-1111");
//        l.setDescription("Best steak place in town!....(for a price :) )");
//        l.setCategory("Restaurant, steak Place");
//        l.setWebsite("www.mortons.donotType");
//        l.setFeatureType("category");
//
//        return l;
//    }
//
//    private Listing buildListing2(){
//        Listing l = new Listing();
//        l.setPrice(5.6);
//        l.setStartDate(LocalDate.of(2013,12,12));
//        l.setEndDate(LocalDate.of(2017,12,12));
//        l.setName("Dominoes");
//        l.setAddress("255 South Holland, Chicago, IL");
//        l.setPhoneNumber("(312) 151-113d");
//        l.setDescription("Pizza in 15 minutes or your money back ");
//        l.setCategory("Pizza");
//        l.setWebsite("www.dominoes.fall");
//        l.setFeatureType("regular");
//
//        return l;
//    }
//
//}
