package com.cs487.oad.entityTest;




import com.cs487.oad.entity.FeatureType;
import com.cs487.oad.entity.Listing;
import com.cs487.oad.util.CONSTANTS;
import com.cs487.oad.util.FUNCTIONS;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

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
    public void testStartDate() {
        listing.setStartDate(CONSTANTS.DEFAULT_DATE);
        assertTrue(CONSTANTS.DEFAULT_DATE.equals(listing.getStartDate()));
    }

    @Test
    public void testStartDateIsSet() {
        listing.setStartDate(NOW);
        assertTrue(NOW.equals(listing.getStartDate()));

    }



    @Test
    public void testEndDate() {
        listing.setEndDate(CONSTANTS.DEFAULT_DATE);
        assertTrue(CONSTANTS.DEFAULT_DATE.equals(listing.getEndDate()));
    }



    @Test
    public void testEndDateIsSet() {
        listing.setEndDate(NOW);
        assertTrue(NOW.equals(listing.getEndDate()));
    }



    @Test
    public void testToString() {
        listing = new Listing();
        String s= decorateListing();
        FUNCTIONS.printToDebug(String.format("\n%s\n%s",s,listing.toString()));
        assertTrue(listing.toString().equals(s));
    }

    private String decorateListing(){
        String name = "NAME";
        listing.setName(name);
        String address = "123 state street, chicago Il";
        listing.setAddress(address);

        String description = "This is a great restaurant";
        listing.setDescription(description);
        LocalDate startDate = LocalDate.of(2016,11,06);
        LocalDate endDate = LocalDate.of(2019,11,06);
        listing.setEndDate(endDate);
        listing.setStartDate(startDate);

        String fe = "fe";
        listing.setFeatureType(FeatureType.NORMAL);
        String phoneNumber = "11-11";
        listing.setPhone(phoneNumber);
        double price = 10.55;
//        listing.setPrice(price);
        String website = "www.red.com";
        listing.setWebsite(website);
        return listing.toString();
    }


}
