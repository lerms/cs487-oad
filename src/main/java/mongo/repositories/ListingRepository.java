package mongo.repositories;
import entity.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alexanderlerma on 10/4/16.
 */

public interface ListingRepository extends MongoRepository<Listing, String> {

    public List<Listing> findByName(String name);

}
