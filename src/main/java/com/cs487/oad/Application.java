package com.cs487.oad;

import com.cs487.oad.services.OADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;



/**
 * Created by alexanderlerma on 10/4/16.
 */

@SpringBootApplication
public class Application implements CommandLineRunner {

    private OADService service;

    @Autowired
    public Application(OADService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                SpringApplication.run(Application.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String name: beanNames)System.out.println(name);

    }

    @Override
    public void run(String... args) {
//        service.emptyCollectionsForTesting();
//        FUNCTIONS.printToDebug("Emptied MongoDB Repositories for testing.");
    }
}
