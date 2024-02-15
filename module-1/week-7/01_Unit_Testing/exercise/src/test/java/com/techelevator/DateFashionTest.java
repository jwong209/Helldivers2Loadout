package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    // Arrange
    private DateFashion dateFashionTest = new DateFashion();

    @Test
    public void getATable_should_return_2_when_5_and_10_are_passed() {
        // Act
        int actual = dateFashionTest.getATable(5, 10);
        int expected = 2;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATable_should_return_0_when_5_and_2_are_passed() {
        // Act
        int actual = dateFashionTest.getATable(5, 2);
        int expected = 0;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATable_should_return_1_when_5_and_5_are_passed() {
        // Act
        int actual = dateFashionTest.getATable(5, 5);
        int expected = 1;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATable_should_return_2_when_10_and_10_are_passed() {
        int actual = dateFashionTest.getATable(10, 10);
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getATable_should_return_0_when_0_and_0_are_passed() {
        int actual = dateFashionTest.getATable(0, 0);
        int expected = 0;

        Assert.assertEquals(expected, actual);
    }

}
