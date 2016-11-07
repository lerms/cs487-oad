package com.cs487.oad.interactorTest;

import com.cs487.oad.entity.Category;
import com.cs487.oad.entity.SubCategory;
import com.cs487.oad.interactors.CategoryInteractor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


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
        categoryInteractor.add(mock(Category.class), sub);
        assertTrue(categoryInteractor.getSize()==1);

    }


}
