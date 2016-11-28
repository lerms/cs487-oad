package com.cs487.oad.entityTest;




import com.cs487.oad.entity.*;
import com.cs487.oad.util.CONSTANTS;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 9/19/2016.
 */
public class ListingTest {


    Listing listing;
    public static final LocalDate NOW = LocalDate.now();
    String name ="name";
    Advertiser advertiser =new Advertiser();
    String image = "IMAGE";
    String address = "address";
    String phone ="phone";
    Location location = new Location("city", "neighborhood");
    String description = "description" ;
    String website = "website";
    FeatureType featureType = FeatureType.NORMAL;
    LocalDate startDate = LocalDate.now();
    LocalDate endDate = LocalDate.MAX;
    Category category = new Category();
    ArrayList<Category> subcategories = new ArrayList<>();


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



    @Test
    public void testCategory() {
        listing.setCategory(category);
        assertTrue(listing.getCategory().equals(category));
    }



    @Test
    public void testName() {
        listing.setName(name);
        assertTrue(listing.getName().equals(name));
    }



    @Test
    public void testAdvertiser() {
        listing.setAdvertiser(advertiser);
        assertTrue(listing.getAdvertiser().equals(advertiser));
    }



    @Test
    public void testImage() {
        listing.setImage(image);
        assertTrue(listing.getImage().equals(image));
    }



    @Test
    public void testAddress() {
        listing.setAddress(address);
        assertTrue(listing.getAddress().equals(address));
    }



    @Test
    public void testLocation() {
        listing.setLocation(location);
        assertTrue(listing.getLocation().equals(location));

    }



    @Test
    public void testPhone() {
        listing.setPhone(phone);
        assertTrue(listing.getPhone().equals(phone));
    }



    @Test
    public void testDescription() {
        listing.setDescription(description);
        assertTrue(listing.getDescription().equals(description));
    }



    @Test
    public void testWebsite() {
        listing.setWebsite(website);
        assertTrue(listing.getWebsite().equals(website));
    }



    @Test
    public void testFeature() {
        listing.setFeatureType(featureType);
        assertTrue(listing.getFeatureType().equals(featureType));
    }



    @Test
    public void testSubcategory() {
        listing.setSubcategories(subcategories);
        assertTrue(listing.getSubcategories().equals(subcategories));
    }



    @Test
    public void testToString() {
        listing = new Listing(name, advertiser,image,address,location,phone,description,
                website,featureType,startDate,endDate,category,subcategories);

        String result = new ToStringBuilder(listing)
                .append("name", name)
                .append("advertiser", advertiser)
                .append("image", image)
                .append("address", address)
                .append("location", location)
                .append("phone", phone)
                .append("description", description)
                .append("website", website)
                .append("featureType", featureType)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("subcategories", subcategories)
                .toString();

        assertTrue(listing.toString().equals(result));
    }


}
