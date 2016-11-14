package interactorTest;



import com.cs487.oad.entity.Advertiser;
import com.cs487.oad.interactors.AdvertiserInteractor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;




/**
 * Created by Jeannius on 11/6/2016.
 */
public class AdvertiserInteractorTest {

    private AdvertiserInteractor advertiserInteractor;



    @Before
    public void setUp() {
        advertiserInteractor = AdvertiserInteractor.getInstance();
    }



    @Test
    public void testSizeIsOne() {
        Advertiser ad = new Advertiser();
        advertiserInteractor.add(ad);
        assertTrue(advertiserInteractor.getSize()==1);
    }



    @Test
    public void testSizeIsZero() {

    }


}
