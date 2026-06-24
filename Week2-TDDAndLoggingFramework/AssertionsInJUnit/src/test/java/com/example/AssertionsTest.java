package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        Assert.assertEquals(5, 2 + 3);
        Assert.assertTrue(5 > 3);
        Assert.assertFalse(5 < 3);
        Assert.assertNull(null);
        Assert.assertNotNull(new Object());
    }
}
