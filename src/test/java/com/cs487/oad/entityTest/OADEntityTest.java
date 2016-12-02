package com.cs487.oad.entityTest;



import com.cs487.oad.entity.OADEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;



/**
 * Created by Jlarrieux on 11/28/2016.
 */
public class OADEntityTest {

    OADEntity oadEntity;



    @Before
    public void setUp() {
        oadEntity = new OADEntity();
    }



    @Test
    public void testGetId() {
        assertFalse(oadEntity.getId()=="jean");
    }
}
