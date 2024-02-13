package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontTimesTest = new FrontTimes();

    @Test
    public void generateString_should_return_ChoCho_when_Chocolate_and_2_are_passed() {
        frontTimesTest.generateString("Chocolate", 2);

        Assert.assertEquals("ChoCho", frontTimesTest.generateString("Chocolate", 2));
    }

    @Test
    public void generateString_should_return_ChoChoCho_when_Chocolate_and_3_are_passed() {
        frontTimesTest.generateString("Chocolate", 3);

        Assert.assertEquals("ChoChoCho", frontTimesTest.generateString("Chocolate", 3));
    }

    @Test
    public void generateString_should_return_AbcAbcAbc_when_Abc_and_3_are_passed() {
        frontTimesTest.generateString("Abc", 3);

        Assert.assertEquals("AbcAbcAbc", frontTimesTest.generateString("Abc", 3));
    }
}
