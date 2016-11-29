package com.cs487.oad.entityTest;



import com.cs487.oad.entity.ListingSearchRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 11/28/2016.
 */
public class ListingSearchRequestTest {

    ListingSearchRequest listingSearchRequest;
    String query = "pizza";
    String city = "Chicago";
    String neighborhood = "Loop";
    String category = "Restaurant";
    String subcategory = "Pizza";


    @Before
    public void setUp() {
        listingSearchRequest = new ListingSearchRequest(query,city,neighborhood,category,subcategory);
    }



    @Test
    public void testCityIsSet() {
        assertTrue(listingSearchRequest.getCity().equals(city));

    }



    @Test
    public void testNeighborhoodIsSet() {
        assertTrue(listingSearchRequest.getNeighborhood().equals(neighborhood));
    }



    @Test
    public void testCategoryIsSet() {
        assertTrue(listingSearchRequest.getCategory().equals(category));
    }



    @Test
    public void testToString() {
        String result =new ToStringBuilder(listingSearchRequest)
                            .append("city", city)
                            .append("neighborhood", neighborhood)
                            .append("category", category)
                            .toString();
//        System.out.println(String.format("tostring:\t%s\n\n\nmine:%s\t", listingSearchRequest.toString(),result));
        assertTrue(listingSearchRequest.toString().equals(result));

    }


    @Test
    public void testSubcategoryIsSet() {

        assertTrue(listingSearchRequest.getSubcategory().equals(subcategory));
    }

}
