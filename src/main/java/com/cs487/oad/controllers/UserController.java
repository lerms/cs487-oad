package com.cs487.oad.controllers;

import com.cs487.oad.entity.ListingSearchRequest;
import com.cs487.oad.entity.LocationDTO;
import com.cs487.oad.services.OADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by alexanderlerma on 11/27/16.
 */
@Controller
public class UserController extends OADRestController {

    @Autowired
    public UserController(OADService oadService) {
        super(oadService);
    }

    @GetMapping("/location")
    public @ResponseBody Map<String, List<LocationDTO>> getLocations() {
        return oadService.findAllLocations();
    }

    @GetMapping("/listing")
    public @ResponseBody Map<String, Object> getListingsFormatted() {
        return oadService.listingsForHomepage();
    }

    @RequestMapping(value = "/listing/search", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> listingSearch(@RequestParam  Map<String, String> requestParams) {
        final String query = requestParams.get("query");
        final String city = requestParams.get("city");
        final String neighborhood = requestParams.get("neighborhood");
        final String category = requestParams.get("category");
        final String subcategory = requestParams.get("subcategory");

        ListingSearchRequest searchRequest = new ListingSearchRequest(query, city, neighborhood, category, subcategory);
        return oadService.searchListings(searchRequest);
    }


}
