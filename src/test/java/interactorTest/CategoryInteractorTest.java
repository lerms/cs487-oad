package interactorTest;




import com.cs487.oad.entity.Category;
import com.cs487.oad.interactors.CategoryInteractor;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jeannius on 10/22/2016.
 */
public class CategoryInteractorTest {

    private CategoryInteractor categoryInteractor;



    @Before
    public void setUp() {
        categoryInteractor = CategoryInteractor.getInstance();
    }






    @Test
    public void testSizeIsOne() {
        Category cat = new Category("test", ObjectId.get(), "s");
        categoryInteractor.add(cat);
        assertTrue(categoryInteractor.getSize()==1);

    }



    @After
    public void tearDown() {
        categoryInteractor = null;
    }


}
