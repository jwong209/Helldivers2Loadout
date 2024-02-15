package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    private StringBits stringBitsTest = new StringBits();

    @Test
    public void getBits_should_return_Hlo_when_Hello_is_passed() {
        String actual = stringBitsTest.getBits("Hello");

        Assert.assertEquals("Hlo", actual);
    }

    @Test
    public void getBits_should_return_H_when_Hi_is_passed() {
        String actual = stringBitsTest.getBits("Hi");

        Assert.assertEquals("H", actual);
    }

    @Test
    public void getBits_should_return_Hello_when_Heeololeo_is_passed() {
        String actual = stringBitsTest.getBits("Heeololeo");

        Assert.assertEquals("Hello", actual);
    }

    @Test
    public void getBits_should_return_emptyString_when_null_is_passed() {
        String actual = stringBitsTest.getBits(null);

        Assert.assertEquals("", actual);
    }

    @Test
    public void getBits_should_return_emptyString_when_emptyString_is_passed() {
        String actual = stringBitsTest.getBits("");

        Assert.assertEquals("", actual);
    }

}
