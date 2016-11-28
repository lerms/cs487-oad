package com.cs487.oad.entityTest;



import com.cs487.oad.entity.FeatureType;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Created by Jlarrieux on 11/28/2016.
 */
public class FeatureTypeTest {


    @Test
    public void testFromStringIsUndefined() {
        assertFalse(FeatureType.fromString("normal").equals(FeatureType.UNDEFINED));
    }



    @Test
    public void testIsValid() {
        assertTrue(FeatureType.isValid("normal"));
    }
}
