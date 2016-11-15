package com.cs487.oad.entityTest;




import com.cs487.oad.entity.Advertiser;
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
    public void testWebLinkIsEmpty() {
        assertTrue(advertiser.getWebsite().equals(""));
    }



    @Test
    public void testWebLinkIsSet() {
        String link = "www.iit.edu";
        advertiser.setWebsite(link);
        assertTrue(advertiser.getWebsite().equals(link));

    }


}
