package com.cs487.oad.controllers;

import com.cs487.oad.entity.LocationDTO;
import com.cs487.oad.services.OADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
