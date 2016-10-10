package com.cs487oad.backend.interactors;



import com.cs487oad.backend.entity.Listing;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Jeannius on 10/8/2016.
 */
public class ListingInteractor {


    private List<Listing> listings = new ArrayList<>();



    public void addListing(Listing listing) {
        listings.add(listing);
    }



    public int getSize() {
        return listings.size();
    }
}
