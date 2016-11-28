package com.cs487.oad.interactorTest;

import com.cs487.oad.entity.Category;
import com.cs487.oad.interactors.CategoryInteractor;
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
    public void testSizeIsZero() {
        assertTrue(categoryInteractor.getSize()==0);

    }



    @Test
    public void testCategory() {
        Category cat = new Category();
        cat.setName("red");
        categoryInteractor.add(cat);
        assertTrue(categoryInteractor.getCategory(cat.getName()).equals(cat));
    }

    @After
    public void tearDown() {
        categoryInteractor.getMap().clear();
    }


}
