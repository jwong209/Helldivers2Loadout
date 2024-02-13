import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class UnitTestingExamplesTest {

    /*
     * [negative even, negative odd]
     * [even #s => true, odd #s => false]
     * [0]
     * [large even #s, large odd #s]
     */
    @Test
    public void isEven() {

        // Arrange
        int[] testInputs = {0, 2, 4, 10, 9990};
        boolean expected = true;

        // Act
        for(int eachTestInput : testInputs) {
            UnitTestingExamples sut = new UnitTestingExamples();
            boolean actual = sut.isEven(eachTestInput);

            // Assert
            //System.out.println("Testing " + eachTestInput);
            Assert.assertEquals("test input: " + eachTestInput, expected, actual);
        }
    }

    /*
     * punctuation: , ; : ' - .
     * null/empty string: expected ????
     * one character: "a" -> "a"
     * whitespace characters: "   ", "hello  world"
     * mixed/all caps: "ABCD", "AbCDE"
     * numbers: "129950", "hello 1 world42"
     * repeated characters: "aaaaaa", "-----"
     */
    @Test
    public void stringSplosion_happy_path() {

        // Arrange
        String input = "Code";
        String expected = "CCoCodCode";

        // Act
        UnitTestingExamples sut = new UnitTestingExamples();
        String actual = sut.stringSplosion(input);

        // Assert
        Assert.assertEquals("error message", expected, actual);
    }

    @Test
    public void stringYak() {
    }
}