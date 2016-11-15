package com.cs487.oad.utilTest;

import com.cs487.oad.util.RepositoryUtils;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * Created by alexanderlerma on 11/15/16.
 */
public class RepositoryUtilsTest {
    @Test
    public void toSluggedString() throws Exception {
        String nonSlug = "A veRY... inteResTING?..!11 String:)";
        String slugged = "a-very-interesting11-string";
        assertEquals(slugged, RepositoryUtils.toSluggedString(nonSlug));
        assertEquals("should-work", RepositoryUtils.toSluggedString("should-WORK"));
    }

}