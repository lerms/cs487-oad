package interactorTest;



import Interactors.CategoryInteractor;
import entity.Category;
import entity.SubCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class CategoryInteractorTest {

    private CategoryInteractor categoryInteractor;



    @Before
    public void setUp() {
        categoryInteractor = new CategoryInteractor();
    }



    @Test
    public void testSizeIsZero() {
        assertTrue(categoryInteractor.getSize()==0);

    }



    @Test
    public void testSizeIsOne() {
        List<SubCategory> sub = new ArrayList<>();
        sub.add(new SubCategory("Test"));
        categoryInteractor.add(new Category("tee"), sub);
        assertTrue(categoryInteractor.getSize()==1);

    }


}
