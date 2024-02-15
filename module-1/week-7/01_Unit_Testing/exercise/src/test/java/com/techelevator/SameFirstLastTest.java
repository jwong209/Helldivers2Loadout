package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    private SameFirstLast sameFirstLastTest = new SameFirstLast();

    @Test
    public void isItTheSame_should_return_false_given_array_1_2_3() {
        boolean actual = sameFirstLastTest.isItTheSame(new int[]{1, 2, 3});

        Assert.assertFalse(actual);
//        Assert.assertEquals(false, actual);
    }

    @Test
    public void isItTheSame_should_return_true_given_array_1_2_3_1_2_3_1() {
        boolean actual = sameFirstLastTest.isItTheSame(new int[]{1, 2, 3, 1, 2, 3, 1});

        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void isItTheSame_should_return_true_given_array_0_2_0() {
        boolean actual = sameFirstLastTest.isItTheSame(new int[]{0, 2, 0});

        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void isItTheSame_should_return_false_given_empty_array() {
        boolean actual = sameFirstLastTest.isItTheSame(new int[]{});

        Assert.assertFalse(actual);
    }

    @Test
    public void isItTheSame_should_return_false_given_null() {
        boolean actual = sameFirstLastTest.isItTheSame(null);

        Assert.assertFalse(actual);
    }

}
