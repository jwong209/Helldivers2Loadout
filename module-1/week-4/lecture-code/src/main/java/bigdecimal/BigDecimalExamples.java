package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*
 * double float imprecision
 * https://0.30000000000000004.com/
 */
public class BigDecimalExamples {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a decimal number: ");
        String userInput = input.nextLine();

        /*
         * Initializing a big decimal object from a string
         */
        BigDecimal decimalNumber = new BigDecimal(userInput);
        System.out.println(decimalNumber);
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));

        /*
         * .compareTo
         * -1  first decimalNumber is less than decimalNumber2
         * 0   first decimalNumber is equal to decimalNumber2
         * 1   first decimalNumber is greater than decimalNumber2
         */
        BigDecimal decimalNumber2 = new BigDecimal("42.0");
        boolean isLessThan = decimalNumber.compareTo(decimalNumber2) == -1;
        boolean isLessThanOrEqualTo = decimalNumber.compareTo(decimalNumber2) <= 0;

        if(isLessThanOrEqualTo){
            // first number is <= the 2nd number
            System.out.println(decimalNumber + " is <= " + decimalNumber2);
        } else {
            System.out.println(decimalNumber + " is > " + decimalNumber2);
        }

        /*
         * Converting a BigDecimal to a double
         */
        double convertedValue = decimalNumber2.doubleValue();

        /*
         * String alphabetical comparisons
         */
        boolean isFirstLetterFirstAlphabetically = "a".compareTo("b") < 0;
        if(isFirstLetterFirstAlphabetically){
            System.out.println("'a' comes before 'b'");
        }
        System.out.println();

        /*
         * Creating BigDecimal values
         */
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;

        // DO NOT use the double constructor, new BigDecimal(0.1)
        BigDecimal value1 = new BigDecimal("0.1");
        BigDecimal value2 = new BigDecimal("0.2");

        BigDecimal five = new BigDecimal("5");
        BigDecimal two = new BigDecimal("2");

        /*
         * Math operators
         */
        System.out.println(value1 + " + " + value2 + " = " + value1.add(value2));
        System.out.println(value1 + " - " + value2 + " = " + value1.subtract(value2));
        System.out.println(value1 + " * " + value2 + " = " + value1.multiply(value2));
        System.out.println(five  + " / " + two    + " = " + five.divide(two));
        System.out.println(five  + " % " + two    + " = " + five.remainder(two));

        /*
         * Setting the number of digits after the decimal point
         */
        BigDecimal three = new BigDecimal("3");
        BigDecimal quotient = two.divide(three, 5, RoundingMode.HALF_UP);
        System.out.println();
        System.out.println("Scale 5 digits after decimal point. Round half up");
        System.out.println(two + " / " + three + " = " + quotient);

        System.out.println();
        System.out.println("Scale 8 digits after decimal point. Round half up");
        System.out.println(value1 + " * " + value2 + " = " + value1.multiply(value2).setScale(8, RoundingMode.HALF_UP));

        System.out.println();

        /*
         * Comparing BigDecimal objects
         */
        System.out.println(value1 + " compareTo " + value2 + " => " + value1.compareTo(value2));
        System.out.println(value2 + " compareTo " + value1 + " => " + value2.compareTo(value1));
        System.out.println(value1 + " compareTo " + value1 + " => " + value1.compareTo(value1));
    }
}
