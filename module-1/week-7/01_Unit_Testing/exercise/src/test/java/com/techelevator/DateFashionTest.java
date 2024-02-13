package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    // Arrange
    private DateFashion dateFashionTest = new DateFashion();

    @Test
    public void getATable_should_return_2_when_5_and_10_are_passed() {
        // Act
        dateFashionTest.getATable(5, 10);

        // Assert
        Assert.assertEquals(2, dateFashionTest.getATable(5, 10));
    }

    @Test
    public void getATable_should_return_0_when_5_and_2_are_passed() {
        // Act
        dateFashionTest.getATable(5, 2);

        // Assert
        Assert.assertEquals(0, dateFashionTest.getATable(5, 2));
    }

    @Test
    public void getATable_should_return_1_when_5_and_5_are_passed() {
        // Act
        dateFashionTest.getATable(5, 5);

        // Assert
        Assert.assertEquals(1, dateFashionTest.getATable(5, 5));
    }

}
