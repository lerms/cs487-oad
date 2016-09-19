package com.cs487oad.test.java;




import com.cs487oad.backend.entity.Advertiser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class AdvertiserTest {

    com.cs487oad.backend.entity.Advertiser advertiser;



    @Before
    public void setUp() {
        advertiser = new Advertiser();
    }



    @Test
    public void testDescriptionIsEmpty() {
        assertTrue(advertiser.getDescription().equals(""));
    }



    @Test
    public void testDescriptionIsSet() {

        String description = "this is a business selling interdimensional travels";
        advertiser.setDescription(description);
        assertTrue(advertiser.getDescription().equals(description));

    }



    @Test
    public void testWebLinkIsEmpty() {
        assertTrue(advertiser.getWebLink().equals(""));
    }



    @Test
    public void testWebLinkIsSet() {
        String link = "www.iit.edu";
        advertiser.setWebLink(link);
        assertTrue(advertiser.getWebLink().equals(link));

    }


}
