package com.cs487.oad.entityTest;

import com.cs487.oad.entity.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Created by alexanderlerma on 10/17/16.
 */
public class CategoryTest {

    private Category category;
    private Category category2;

    @Before
    public void setUp() {
        category = mock(Category.class);
        category2 = new Category();
    }

    @Test
    public void testAddSubcategory() {
        List<Category> subcats = new ArrayList<>(5);
        for(int i = 0; i < 5; i++) {
            subcats.add(mock(Category.class));
        }
        subcats.forEach(sub -> category.addAncestorCategory(sub));
        category.getAncestors()
                .forEach(sub -> assertTrue(subcats.stream()
                        .anyMatch(x -> x.getId().equals(sub.getId()))));
    }



    @Test
    public void testNameIsSet() {
        String test = "test";
        Category cat = new Category(test,"","", null);
        cat.setName(test);
        assertTrue(cat.getName().equals(test));

    }



    @Test
    public void testSlugIsSet() {
        String test = "test";
        Category cat = new Category("","",test, null);
        cat.setSlug(test);
        assertTrue(cat.getSlug().equals(test));

    }



    @Test
    public void testParentIdIsSet() {
        String test = "test";
        Category cat = new Category("",test,"", null);

        assertTrue(cat.getParentId().equals(test));
    }
}
