package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    private MaxEnd3 maxEnd3Test = new MaxEnd3();

    @Test
    public void makeArray_should_return_array3_3_3_when_array1_2_3_is_passed() {
        maxEnd3Test.makeArray(new int[]{1, 2, 3});

        Assert.assertArrayEquals(new int[]{3, 3, 3}, maxEnd3Test.makeArray(new int[]{1, 2, 3}));
    }

    @Test
    public void makeArray_should_return_array11_11_11_when_array11_5_9_is_passed() {
        maxEnd3Test.makeArray(new int[]{11, 5, 9});

        Assert.assertArrayEquals(new int[]{11, 11, 11}, maxEnd3Test.makeArray(new int[]{11, 5, 9}));
    }
    @Test
    public void makeArray_should_return_array3_3_3_when_array2_11_3_is_passed() {
        maxEnd3Test.makeArray(new int[]{2, 11, 3});

        Assert.assertArrayEquals(new int[]{3, 3, 3}, maxEnd3Test.makeArray(new int[]{2, 11, 3}));
    }

}
