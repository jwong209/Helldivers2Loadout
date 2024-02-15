package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    private NonStart nonStartTest = new NonStart();

    @Test
    public void getPartialString_should_return_ellohere_when_Hello_and_There_are_passed() {
        String actual = nonStartTest.getPartialString("Hello", "There");
        String expected = "ellohere";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialString_should_return_avaode_when_java_and_code_are_passed() {
        String actual = nonStartTest.getPartialString("java", "code");
        String expected = "avaode";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialString_should_return_hotlava_when_shotl_and_java_are_passed() {
        String actual = nonStartTest.getPartialString("shotl", "java");
        String expected = "hotlava";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialString_should_return_JAVA_when_emptyString_and_MJAVA_are_passed() {
        String actual = nonStartTest.getPartialString("", "MJAVA");
        String expected = "JAVA";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialString_should_return_JAVA_when_MJAVA_and_emptyString_are_passed() {
        String actual = nonStartTest.getPartialString("MJAVA", "");
        String expected = "JAVA";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPartialString_should_return_emptyString_when_null_and_null_are_passed() {
        String actual = nonStartTest.getPartialString(null, null);
        String expected = "";

        Assert.assertEquals(expected, actual);
    }

}
