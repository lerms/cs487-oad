package com.cs487.oad.entityTest;



import com.cs487.oad.entity.Location;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 11/28/2016.
 */
public class LocationTest {

    Location location;
    String city = "Chicago";
    String nei = "LOOP";


    @Before
    public void setUp() {
        location = new Location(city,nei);
    }



    @Test
    public void testCityIsSet() {
        assertTrue(location.getCity().equals(city));
    }



    @Test
    public void testNeighborhoodIsSet() {
        assertTrue(location.getNeighborhood().equals(nei));
    }



    @Test
    public void testCityIsSetAsNew() {
        String city2 = "miami";
        location.setCity(city2);
        assertTrue(location.getCity().equals(city2));
    }



    @Test
    public void testNeiborhoodIsSetNew() {
        String n2 = "palmeto";
        location.setNeighborhood(n2);
        assertTrue(location.getNeighborhood().equals(n2));
    }



    @Test
    public void testToString() {
        String result = new ToStringBuilder(location)
                .append("city", city)
                .append("neighborhood", nei)
                .toString();
        assertTrue(location.toString().equals(result));

    }

}
