package com.cs487.oad.entityTest;




import com.cs487.oad.entity.Advertiser;
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
    public void testWebLinkIsEmpty() {
        assertNull(advertiser.getWebsite());
    }



    @Test
    public void testWebLinkIsSet() {
        String link = "www.iit.edu";
        advertiser.setWebsite(link);
        assertTrue(advertiser.getWebsite().equals(link));

    }



    @Test
    public void testNameIsSet() {
        String name = "name";
        advertiser.setName(name);
        assertTrue(advertiser.getName().equals(name));
    }



    @Test
    public void testPhoneNumberIsSet() {
        String PHONE= "1111";
        advertiser.setPhone(PHONE);
        assertTrue(advertiser.getPhone().equals(PHONE));
    }



    @Test
    public void testEmailIsSet() {
        String email = "email@email.com";
        advertiser.setEmail(email);
        assertTrue(advertiser.getEmail().equals(email));

    }



    @Test
    public void testToString() {
        String name = "name";
        String phone ="1111";
        String website = "website.com";
        String email = "email@email.com";
        String description = "description";

        Advertiser ad = new Advertiser(name, phone,website,email,description);
//        System.out.println("\n"+ad.toString());
//        assertTrue(ad.toString().equals(name+phone+website+email+description));
    }

}
