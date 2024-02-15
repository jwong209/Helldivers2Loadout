package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontTimesTest = new FrontTimes();

    @Test
    public void generateString_should_return_ChoCho_when_Chocolate_and_2_are_passed() {
        String actual = frontTimesTest.generateString("Chocolate", 2);
        String expected = "ChoCho";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateString_should_return_ChoChoCho_when_Chocolate_and_3_are_passed() {
        String actual = frontTimesTest.generateString("Chocolate", 3);
        String expected = "ChoChoCho";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateString_should_return_AbcAbcAbc_when_Abc_and_3_are_passed() {
        String actual = frontTimesTest.generateString("Abc", 3);
        String expected = "AbcAbcAbc";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateString_should_return_emptyString_when_emptyString_and_3_are_passed() {
        String actual = frontTimesTest.generateString("", 3);
        String expected = "";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateString_should_return_threeSpaces_when_singleSpace_and_3_are_passed() {
        String actual = frontTimesTest.generateString(" ", 3);
        String expected = "   ";

        Assert.assertEquals(expected, actual);
    }
}
