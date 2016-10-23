package interactorTest;



import Interactors.ListingInteractor;
import entity.Listing;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class ListingInteractorTest {

    ListingInteractor listingInteractor;



    @Before
    public void setUp() {
        listingInteractor = new ListingInteractor();
    }



    @Test
    public void testSizeIsZero() {
        assertTrue(listingInteractor.getSize()==0);

    }



    @Test
    public void testSizeIsOneWhenListingAdded() {
        listingInteractor.addListing(new Listing());
        assertTrue(listingInteractor.getSize()==1);

    }


}
