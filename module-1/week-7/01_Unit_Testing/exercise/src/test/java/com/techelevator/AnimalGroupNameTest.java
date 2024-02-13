package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    // Arrange - data is already set in the AnimalGroupName class
    private AnimalGroupName animalGroupTest = new AnimalGroupName();

    @Test
    public void getHerd_should_return_Tower_when_giraffe_is_passed() {
        // Act
        animalGroupTest.getHerd("giraffe");

        // Assert
        Assert.assertEquals("Tower", animalGroupTest.getHerd("giraffe"));
    }

    @Test
    public void getHerd_should_return_Tower_when_Giraffe_is_passed() {
        // Act
        animalGroupTest.getHerd("Giraffe");

        // Assert
        Assert.assertEquals("Tower", animalGroupTest.getHerd("Giraffe"));
    }

    @Test
    public void getHerd_should_return_unknown_when_emptyString_is_passed() {
        // Act
        animalGroupTest.getHerd("\"\"");

        // Assert
        Assert.assertEquals("unknown", animalGroupTest.getHerd("\"\""));
    }

    @Test
    public void getHerd_should_return_unknown_when_walrus_is_passed() {
        // Act
        animalGroupTest.getHerd("walrus");

        // Assert
        Assert.assertEquals("unknown", animalGroupTest.getHerd("walrus"));
    }

    @Test
    public void getHerd_should_return_Crash_when_Rhino_is_passed() {
        // Act
        animalGroupTest.getHerd("Rhino");

        // Assert
        Assert.assertEquals("Crash", animalGroupTest.getHerd("Rhino"));
    }

    @Test
    public void getHerd_should_return_Crash_when_rhino_is_passed() {
        // Act
        animalGroupTest.getHerd("rhino");

        // Assert
        Assert.assertEquals("Crash", animalGroupTest.getHerd("rhino"));
    }

    @Test
    public void getHerd_should_return_unknown_when_elephants_is_passed() {
        // Act
        animalGroupTest.getHerd("elephants");

        // Assert
        Assert.assertEquals("unknown", animalGroupTest.getHerd("elephants"));
    }

    @Test
    public void getHerd_should_return_unknown_when_null_is_passed() {
        // Act
        animalGroupTest.getHerd(null);

        // Assert
        Assert.assertEquals("unknown", animalGroupTest.getHerd(null));
    }

}
