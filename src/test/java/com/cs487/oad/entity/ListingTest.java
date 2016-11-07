package com.cs487.oad.entity;

import org.junit.Before;
import org.junit.Test;
import com.cs487.oad.util.CONSTANTS;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class ListingTest {


    Listing listing;
    public static final LocalDate NOW = LocalDate.now();



    @Before
    public void setUp() {
        listing = new Listing();
    }



    @Test
    public void testListingPriceIsZero() {
        assertTrue(listing.getPrice()==0);
    }



    @Test
    public void testListingPriceAfterItIsSet() {
        double price= 15.55;
        listing.setPrice(price);
        assertEquals(price, listing.getPrice(), 0.0001);

    }



    @Test
    public void testStartDate() {
        assertTrue(CONSTANTS.DEFAULT_DATE.equals(listing.getStartDate()));
    }

    @Test
    public void testStartDateIsSet() {
        listing.setStartDate(NOW);
        assertTrue(NOW.equals(listing.getStartDate()));

    }



    @Test
    public void testEndDate() {
        assertTrue(CONSTANTS.DEFAULT_DATE.equals(listing.getEndDate()));
    }



    @Test
    public void testEndDateIsSet() {
        listing.setEndDate(NOW);
        assertTrue(NOW.equals(listing.getEndDate()));
    }



    @Test
    public void testListingNameIsSet() {
        String test = "test";
        listing.setName(test);
        assertTrue(listing.getName().equals(test));
    }



    @Test
    public void testListingDescriptionIsSet() {
        String s = "this is a great listing";
        listing.setDescription(s);
        assertTrue(listing.getDescription().equals(s));
    }



    @Test
    public void testListingCityIsSet() {
        String chicago = "Chicago";
        listing.setCity(chicago);
        assertTrue(listing.getCity().equals(chicago));

    }


}
