package entity;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexanderlerma on 10/17/16.
 */
public class Category {
    @Id
    public String id;
    public String name;
    public List<Listing> listings;
    public Set<String> subcategoryIds;

    public void addSubcategory(Category sub) {
        subcategoryIds.add(sub.id);
    }

    public void addListing(Listing listing) {
        listing.setCategory(id);
        listings.add(listing);
    }

    public Set<String> getSubcategories() {
        return new HashSet<>(subcategoryIds);
    }
}
