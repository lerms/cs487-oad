package entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

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
        subcats.forEach(sub -> category.addSubcategory(sub));
        category.getSubcategories()
                .forEach(sub -> assertTrue(subcats.stream()
                        .anyMatch(x -> x.id.equals(sub))));
    }
}
