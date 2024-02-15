import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UnitTestingExamplesTest {

    UnitTestingExamples sut;

    @Before
    public void setup(){
        //System.out.println("===SETUP===");
        this.sut = new UnitTestingExamples();
    }

    /*
     * TEST INPUTS:
     * even nums: [2, 4]
     * odd nums: [1, 3, 5]
     * zero: [0]
     * negative numbers: [-2, -4, -6]
     * large numbers: [-999, 999, 1000000]
     */
    @Test
    public void isEven_large_even_numbers() {

        // Arrange
        int[] testInputs = {2, 4, 100};
        boolean expected = true;

        // Act
        for(int eachInput : testInputs) {
            boolean actual = sut.isEven(eachInput);

            // Assert
            Assert.assertEquals("Testing input " + eachInput, expected, actual);
        }
    }

    /*
     * TEST INPUTS:
     * empty string: [""] -> ???/undefined
     * happy path: ["Code", "abc", "ab"]
     * one letter string: ['a']
     * long string: ['I'm drawing a blank right now...']
     * special characters: ['$', '@', '1234@759F--;<d298d8']
     * mixed caps: ['ABCD EFgh ijk']
     * all spaces: [" ", "           "]
     */
    @Test
    public void stringSplosion_happy_path() {

        // Arrange
        String[] testInputs = {"Code", "abc", "ab"};
        String[] expected = {"CCoCodCode", "aababc", "aab"};

        for(int i = 0; i < testInputs.length; i++) {
            String eachTestInput = testInputs[i];

            // Act
            String actual = sut.stringSplosion(eachTestInput);

            // Assert
            Assert.assertEquals("Testing element: " + eachTestInput, expected[i], actual);
        }
    }

    @Test
    public void stringYak() {
    }
}