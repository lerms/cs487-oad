package com.cs487.oad.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
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
        assertNull(advertiser.getName());
    }



    @Test
    public void testDescriptionIsSet() {

        String description = "this is a business selling interdimensional travels";
        advertiser.setName(description);
        assertTrue(advertiser.getName().equals(description));

    }



    @Test
    public void testEmailIsEmpty() {
        assertNull(advertiser.getEmail());
    }



    @Test
    public void testEmailIsSet() {
        String link = "www.iit.edu";
        advertiser.setEmail(link);
        assertTrue(advertiser.getEmail().equals(link));

    }



    @Test
    public void testPhoneNumber() {
        advertiser.setPhone("999-999-9999");

    }



    @Test
    public void testWebLinkIsEmpty() {
        assertNull(advertiser.getWebsite());

    }



    @Test
    public void testWebLinkIsSet() {
        String link ="www.example.com";
        advertiser.setWebsite(link);
        assertTrue(advertiser.getWebsite().equals(link));

    }


}
