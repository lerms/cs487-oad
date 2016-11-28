package com.cs487.oad.utilTest;



import com.cs487.oad.util.QueryField;
import org.junit.Test;

import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 11/28/2016.
 */
public class QueryFieldTest {


    @Test
    public void testFromStringUndefined() {
        assertTrue(QueryField.fromString("RED").equals(QueryField.UNDEFINED));
    }



    @Test
    public void testIsValid() {
        assertTrue(QueryField.isValid("NAME"));

    }
}
