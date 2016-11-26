package com.cs487.oad.interactors;


import com.cs487.oad.entity.Listing;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jeannius on 10/22/2016.
 */
public class ListingInteractor {

    private List<Listing> listings = new ArrayList<>();


    //Initialization-on-Demand Holder Idiom
    //see wikipedia: https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    //and this blog post for explanation http://blog.crazybob.org/2007/01/lazy-loading-singletons.html

    private ListingInteractor() {

    }


    private static class ListingInteractorHolder {
        public static ListingInteractor INSTANCE = new ListingInteractor();
    }

    public static ListingInteractor getInstance() {
        return ListingInteractorHolder.INSTANCE;
    }
//***end of IODH


    public int getSize() {
        return listings.size();
    }


    public void addListing(Listing listing) {
        listings.add(listing);
    }
}
