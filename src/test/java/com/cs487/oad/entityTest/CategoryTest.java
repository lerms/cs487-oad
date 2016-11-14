package com.cs487.oad.entityTest;

import com.cs487.oad.entity.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertTrue;


/**
 * Created by alexanderlerma on 10/17/16.
 */
public class CategoryTest {

    private Category category;

    @Before
    public void setUp() {
        category = mock(Category.class);
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
}
