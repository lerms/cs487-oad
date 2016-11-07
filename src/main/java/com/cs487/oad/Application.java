package com.cs487.oad;

import com.cs487.oad.entity.Category;
import com.cs487.oad.services.OADService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;

import java.util.stream.Collectors;


/**
 * Created by alexanderlerma on 10/4/16.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {


    public final OADService oadService;

    @Autowired
    public Application(OADService oadService) {
        this.oadService = oadService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Category root = oadService.createCategory("root", "root", null);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(root));

        Category food = oadService.createCategory("food", "food", root.getId());
        System.out.println(gson.toJson(food));





    }
}
