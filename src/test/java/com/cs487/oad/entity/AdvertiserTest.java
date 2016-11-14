package com.cs487.oad.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class AdvertiserTest {

    Advertiser advertiser;



    @Before
    public void setUp() {
        advertiser = new Advertiser();
    }



    @Test
    public void testDescriptionIsEmpty() {

        assertNull(advertiser.getDescription());
    }



    @Test
    public void testDescriptionIsSet() {

        String description = "this is a business selling interdimensional travels";
        advertiser.setDescription(description);
        assertTrue(advertiser.getDescription().equals(description));

    }



    @Test
    public void testWebSiteIsEmpty() {
        assertNull(advertiser.getWebsite());
    }



    @Test
    public void testWebSiteIsSet() {
        String link = "www.iit.edu";
        advertiser.setWebsite(link);
        assertTrue(advertiser.getWebsite().equals(link));

    }


}
