package mongo.controllers;

import entity.Listing;
import mongo.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by alexanderlerma on 10/4/16.
 */
@RestController
public class ListingController {
    @Autowired
    public ListingRepository listings;

    @RequestMapping(value="/listing", method=RequestMethod.GET)
    public List<Listing> getAllListings() {
        return listings.findAll();
    }

    @RequestMapping(value="/listing/{name}", method=RequestMethod.GET)
    public List<Listing> getListingsByName(@PathVariable("name") String name) {
        return listings.findByName(name);
    }

    @RequestMapping(value="/listing", method=RequestMethod.PUT)
    public void putListing(@RequestParam("listing") Listing listing) {
        listings.save(listing);
    }
}
