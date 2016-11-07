package com.cs487.oad.entity;

import org.junit.Before;
import org.junit.Test;
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
        assertTrue(advertiser.getName().equals(""));
    }



    @Test
    public void testDescriptionIsSet() {

        String description = "this is a business selling interdimensional travels";
        advertiser.setDescription(description);
        assertTrue(advertiser.getName().equals(description));

    }



    @Test
    public void testEmailIsEmpty() {
        assertTrue(advertiser.getEmail().equals(""));
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
        assertTrue(advertiser.getWebsite().equals(""));

    }



    @Test
    public void testWebLinkIsSet() {
        String link ="www.example.com";
        advertiser.setWebsite(link);
        assertTrue(advertiser.getWebsite().equals(link));

    }


}
