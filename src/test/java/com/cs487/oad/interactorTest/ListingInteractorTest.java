package com.cs487.oad.interactorTest;


import com.cs487.oad.entity.Listing;
import com.cs487.oad.interactors.ListingInteractor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class ListingInteractorTest {

    ListingInteractor listingInteractor;



    @Before
    public void setUp() {
        listingInteractor = ListingInteractor.getInstance();
    }



    @Test
    public void testSizeIsZero() {
        assertTrue(listingInteractor.getSize()==0);

    }



    @Test
    public void testSizeIsOneWhenListingAdded() {
        listingInteractor.addListing(new Listing());
        assertTrue(listingInteractor.getSize()==1);

    }


}
