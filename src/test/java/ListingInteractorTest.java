package com.cs487oad.test.java;



import com.cs487oad.backend.entity.Listing;
import com.cs487oad.backend.interactors.ListingInteractor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jeannius on 10/8/2016.
 */
public class ListingInteractorTest {

    ListingInteractor listingInteractor;

    @Before
    public void setUp() {
        listingInteractor = new ListingInteractor();
    }


    @Test
    public void testSizeIsZero() {
        assertTrue(listingInteractor.getSize()==0);
    }



    @Test
    public void testSizeIsGreaterThanZero() {
        listingInteractor.addListing(new Listing());
        assertTrue(listingInteractor.getSize()==1);
    }

}
