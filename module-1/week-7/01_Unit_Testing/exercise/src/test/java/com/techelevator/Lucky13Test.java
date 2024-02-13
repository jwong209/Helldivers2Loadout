package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    private Lucky13 lucky13Test = new Lucky13();

    @Test
    public void getLucky_should_return_true_when_array_0_2_4_is_passed() {
        boolean actual = lucky13Test.getLucky(new int[]{0, 2, 4});

        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
//        Assert.assertTrue("error", actual);
    }

    @Test
    public void getLucky_should_return_false_when_array_1_2_3_is_passed() {
        boolean actual = lucky13Test.getLucky(new int[]{1, 2, 3});

        Assert.assertFalse(actual);
//        Assert.assertEquals(false, actual);
    }

    @Test
    public void getLucky_should_return_false_when_array_1_2_4_is_passed() {
        boolean actual = lucky13Test.getLucky(new int[]{1, 2, 4});

        Assert.assertFalse(actual);
//        Assert.assertEquals(false, actual);
    }

}
