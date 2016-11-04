package com.cs487.oad.interactors;



import com.cs487.oad.entity.Listing;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class ListingInteractor {

    private List<Listing> listings = new ArrayList<>();



    public int getSize() {
        return listings.size();
    }



    public void addListing(Listing listing) {
        listings.add(listing);
    }
}
