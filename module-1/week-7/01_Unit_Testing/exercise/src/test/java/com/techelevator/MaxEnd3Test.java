package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    private MaxEnd3 maxEnd3Test = new MaxEnd3();

    @Test
    public void makeArray_should_return_array_3_3_3_when_array_1_2_3_is_passed() {
        int[] actual = maxEnd3Test.makeArray(new int[]{1, 2, 3});
        int[] expected = new int[]{3, 3, 3};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void makeArray_should_return_array_11_11_11_when_array_11_5_9_is_passed() {
        int[] actual = maxEnd3Test.makeArray(new int[]{11, 5, 9});
        int[] expected = new int[]{11, 11, 11};

        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void makeArray_should_return_array_3_3_3_when_array_2_11_3_is_passed() {
        int[] actual = maxEnd3Test.makeArray(new int[]{2, 11, 3});
        int[] expected = new int[]{3, 3, 3};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void makeArray_should_return_array_4_4_4_when_array_4_8_4_is_passed() {
        int[] actual = maxEnd3Test.makeArray(new int[]{4, 8, 4});
        int[] expected = new int[]{4, 4, 4};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void makeArray_should_return_array_negative4_negative4_negative4_when_array_negative4_negative8_negative12_is_passed() {
        int[] actual = maxEnd3Test.makeArray(new int[]{-4, -8, -12});
        int[] expected = new int[]{-4, -4, -4};

        Assert.assertArrayEquals(expected, actual);
    }

}
