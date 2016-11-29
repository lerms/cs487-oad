package com.cs487.oad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



/**
 * Created by Jeannius on 11/26/2016.
 */
@Controller
public class indexController {


    @RequestMapping( "/"  )
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        return new RedirectView("index.html");
    }


    @RequestMapping( value = "/admin")
    public RedirectView redirectWithUsingRedirectViewadmin(RedirectAttributes attributes) {
        return new RedirectView("administrator.html");
    }

}
