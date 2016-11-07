package com.cs487.oad.controllers;

import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.repositories.AdvertiserRepository;
import com.cs487.oad.services.OADService;
import com.google.common.base.Preconditions;
import org.apache.catalina.filters.RestCsrfPreventionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by alexanderlerma on 10/16/16.
 */
@RestController
@RequestMapping("/advertiser")
public class AdvertiserController {

    private OADService oadService;

    public AdvertiserController(OADService oadService) {
        this.oadService = oadService;
    }


    @GetMapping("/")
    public List<Advertiser> getAllAdvertisers() {
        return oadService.findAdvertisers();
    }


    @RequestMapping(value="/advertiser", method=RequestMethod.PUT)
    public void putAdvertiser(@RequestBody Advertiser advertiser) {
        Preconditions.checkNotNull(advertiser);
        oadService.saveAdvertiser(advertiser);
    }
}
