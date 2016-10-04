package mongo;

import entity.Listing;
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
    private ListingRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        repository.save(new Listing("Morton's", "123 South Ave, Chicago IL",
                "(318) 265-1865",
                "Casual fare restaurant with best pizza in town.",
                "Restaurants",
                "mortons.com",
                "category", 2000.0));
        List<Listing> found = repository.findByName("Morton's");
        System.out.println(found);
    }
}
