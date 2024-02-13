package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    // Arrange
    private CigarParty cigarPartyTest = new CigarParty();

    @Test
    public void haveParty_should_return_false_when_30_false_are_passed() {
        // Act
        boolean actual = cigarPartyTest.haveParty(30, false);

        // Assert
        Assert.assertFalse(actual);
//        Assert.assertEquals(false, actual);

    }

    @Test
    public void haveParty_should_return_true_when_50_false_are_passed() {
        // Act
        boolean actual = cigarPartyTest.haveParty(50, false);

        // Assert
        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void haveParty_should_return_true_when_70_true_are_passed() {
        // Act
        boolean actual = cigarPartyTest.haveParty(70, true);

        // Assert
        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void haveParty_should_return_true_when_40_false_are_passed() {
        // Act
        boolean actual = cigarPartyTest.haveParty(40, false);

        // Assert
        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }

    @Test
    public void haveParty_should_return_true_when_60_false_are_passed() {
        // Act
        boolean actual = cigarPartyTest.haveParty(60, false);

        // Assert
        Assert.assertTrue(actual);
//        Assert.assertEquals(true, actual);
    }



}
