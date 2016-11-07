package com.cs487.oad.boundaries.RestControllers;



import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.Listing;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by Jlarrieux on 10/17/2016.
 */
@RestController
public class testController extends AbstractRestController{


    @GetMapping(value = "/JsonObject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Integer> testingThis(){
        Map<String, Integer> map = new HashMap<>();
        map.put("fIVE", 5);
        return map;
    }


    @RequestMapping(value = "/")
    public String home(){
        return "hello World";
    }


    @GetMapping(value = "/listing", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String getListings(){
        Category c = new Category("Restaurant", ObjectId.get(),"E");
        Advertiser ad = new Advertiser("This is a great advertiser", "www.tallycap.com");
        return gson.toJson(c);

    }


    private Listing buildListing(){
        Listing l = new Listing();
        l.setPrice(175.6);
        l.setStartDate(LocalDate.of(2013,12,12));
        l.setEndDate(LocalDate.of(2017,12,12));
        l.setName("Morton's");
        l.setAddress("1212 South Ave, Chicago, IL");
        l.setPhoneNumber("(312) 111-1111");
        l.setDescription("Best steak place in town!....(for a price :) )");
//        l.setCategory("Restaurant, steak Place"); todo: get this right!
        l.setWebsite("www.mortons.donotType");
        l.setFeatureType("category");

        return l;
    }

    private Listing buildListing2(){
        Listing l = new Listing();
        l.setPrice(5.6);
        l.setStartDate(LocalDate.of(2013,12,12));
        l.setEndDate(LocalDate.of(2017,12,12));
        l.setName("Dominoes");
        l.setAddress("255 South Holland, Chicago, IL");
        l.setPhoneNumber("(312) 151-113d");
        l.setDescription("Pizza in 15 minutes or your money back ");
//        l.setCategory("Pizza"); //todo: get this right!
        l.setWebsite("www.dominoes.fall");
        l.setFeatureType("regular");

        return l;
    }

}
