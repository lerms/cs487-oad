package entityTest;




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
        assertNull(advertiser.getName());
    }



    @Test
    public void testDescriptionIsSet() {

        String description = "this is a business selling interdimensional travels";
        advertiser.setName(description);
        assertTrue(advertiser.getName().equals(description));

    }



    @Test
    public void testWebLinkIsEmpty() {
        assertNull(advertiser.getEmail());
    }



    @Test
    public void testWebLinkIsSet() {
        String link = "www.iit.edu";
        advertiser.setEmail(link);
        assertTrue(advertiser.getEmail().equals(link));

    }


}
