package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    private Less20 less20Test = new Less20();

    @Test
    public void isLessThanMultipleOf20_should_return_true_when_18_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(18);

        Assert.assertTrue(actual);
    }
    @Test
    public void isLessThanMultipleOf20_should_return_true_when_38_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(38);

        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void isLessThanMultipleOf20_should_return_true_when_19_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(19);

        Assert.assertTrue(actual);
    }
    @Test
    public void isLessThanMultipleOf20_should_return_true_when_39_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(39);

        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void isLessThanMultipleOf20_should_return_false_when_40_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(40);

        Assert.assertFalse(actual);
//        Assert.assertEquals(false, actual);
    }

    @Test
    public void isLessThanMultipleOf20_should_return_false_when_0_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(0);

        Assert.assertFalse(actual);
    }

    @Test
    public void isLessThanMultipleOf20_should_return_false_when_negative19_is_passed() {
        boolean actual = less20Test.isLessThanMultipleOf20(-19);

        Assert.assertFalse(actual);
    }



}
