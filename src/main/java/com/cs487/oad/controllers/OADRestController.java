package com.cs487.oad.controllers;


import com.cs487.oad.services.OADService;

/**
 * Created by Jeannius on 10/22/2016.
 */
public abstract class OADRestController {

    protected final OADService oadService;

    protected OADRestController(OADService oadService) {
        this.oadService = oadService;
    }
}
