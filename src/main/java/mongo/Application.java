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

    @Autowired
    private ListingRepository listingRepository;
    @Autowired
    private AdvertiserRepository advertiserRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        listingRepository.deleteAll();
        listingRepository.save(new Listing("Morton's", "123 South Ave, Chicago IL",
                "(318) 265-1865",
                "Casual fare restaurant with best pizza in town.",
                "Restaurants",
                "mortons.com",
                "category", 2000.0));
        listingRepository.save(new Listing("John's", "123 South Ave, Chicago IL",
                "(318) 265-1865",
                "Casual fare restaurant with best pizza in town.",
                "Restaurants",
                "mortons.com",
                "category", 2000.0));
        advertiserRepository.save(new Advertiser());
        List<Listing> found = listingRepository.findByName("Morton's");
        System.out.println(found);
    }
}
