package mongo.controllers;

import entity.Advertiser;
import mongo.repositories.AdvertiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by alexanderlerma on 10/16/16.
 */
@RestController
@RequestMapping("/advertiser")
public class AdvertiserController {

    @Autowired
    public AdvertiserRepository advertisers;

    @GetMapping("/")
    public List<Advertiser> getAllAdvertisers() {
        return advertisers.findAll();
    }

    @RequestMapping(value = "/{description}", method = RequestMethod.GET)
    public List<Advertiser> getAdvertiserByDescription(@PathVariable("description") String description) {

        return advertisers.findByDescription(description);
    }

    @RequestMapping(value="/advertiser", method=RequestMethod.PUT)
    public void putAdvertiser(@RequestParam("advertiser") Advertiser advertiser) {
        advertisers.save(advertiser);
    }
}
