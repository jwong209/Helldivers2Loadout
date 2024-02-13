package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    private NonStart nonStartTest = new NonStart();

    @Test
    public void getPartialString_should_return_ellohere_when_Hello_and_There_are_passed() {
        nonStartTest.getPartialString("Hello", "There");

        Assert.assertEquals("ellohere", nonStartTest.getPartialString("Hello", "There"));
    }

    @Test
    public void getPartialString_should_return_avaode_when_java_and_code_are_passed() {
        nonStartTest.getPartialString("java", "code");

        Assert.assertEquals("avaode", nonStartTest.getPartialString("java", "code"));
    }

    @Test
    public void getPartialString_should_return_hotlava_when_shotl_and_java_are_passed() {
        nonStartTest.getPartialString("shotl", "java");

        Assert.assertEquals("hotlava", nonStartTest.getPartialString("shotl", "java"));
    }

}
