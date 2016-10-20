package mongo;

import entity.Advertiser;
import entity.Listing;
import mongo.repositories.AdvertiserRepository;
import mongo.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


/**
 * Created by alexanderlerma on 10/4/16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
