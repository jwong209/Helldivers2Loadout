// do not code here...yet :)

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello purple class");
        System.out.println("this is the second print statement");

        /*
         * Variables
         */
        // whole #
        int score = 0;

        // decimal #
        double decimalNumber = 3.14;

        // true/false
        boolean isMonday = true;

        // single character
        char firstLetter = 'a';
        firstLetter = 'A';

        // Does not need to be this verbose, but more
        // verbose is better than too terse
        int numberOfNickelsLenaHas = 5;
        int numberOfNickelsBrandonHas = 12;
        int numberOfNickelsBrandonHasMoreThanLena = numberOfNickelsBrandonHas - numberOfNickelsLenaHas;

        // 12 and 5 are *MAGIC NUMBERS* that lead to errors
        // hard to track down the origin of the numbers ....
        int moreNickels = 12 - 5;

        // This is the same as.... score += 1
        score = score + 1;

        // Always add () around compound calculations
        //         (100)      * (-3)
        score = (score * 100) * (2 - 5);

        // NEVER DO SOMETHING LIKE THIS
        score = score * 100 / 2 - 5;

        // + and value with a String changes it to it's String representation
        //                                  10 => "10"
        System.out.println("My score is: " + score);

        // (int * double) calculation promotes to a double value
        int total = (int)(score * decimalNumber);
        double totalDouble = score * decimalNumber;

        // int cast (int) drops any value after the decimal point
        System.out.println((int)42.999999999);

        // int values can be stored into a double with no cast
        // because double can represent a larger range of values
        double newDoubleVariable = score;

        System.out.println("5 / 9 is: "     + (5 / 9));
        System.out.println("5.0 / 9.0 is: " + (5.0 / 9.0));

        // Boolean expression
        boolean isPositiveNumber = score > 0;

        /*
         * Boolean expressions and Conditional Logic
         */
        // valid values are: monday, tuesday, wednesday, thursday, friday, saturday, sunday
        String dayOfTheWeek = "monday";

        int highScore = 42;
        boolean isWeekday = true; //dayOfTheWeek.equals("monday") || dayOfTheWeek.equals("tuesday") || ...;

        if(!isWeekday){
            // This code runs only on Saturday and Sunday
        }

        score = 5;

        if( score == 0 ) {
            System.out.println("OUch! You got a donut/bagel");
        } else if( score > highScore ) {
            System.out.println("congrats on the new high score!!!!");
            highScore = score;
        } else if( score >= 5 ){
            System.out.println("Good job");
        } else {
            System.out.println("Not too shabby");
        }

        System.out.println("END OF print statements");


        String name = "Jacob";

        if(name.equalsIgnoreCase("JACOB")){
            System.out.println("hello " + name);
        }

        /*
         * METHOD CALLS
         */
        greetStudent("Regis");
        greetStudent("Lena");
        greetStudent("Charlie");
    }

    /*
     * METHOD DEFINITION
     *  1. name => greetStudent
     *  2. input parameters => String name
     *  3. return type => int
     *  4. return statement with value matching return type
     */
    static int greetStudent(String name){
        System.out.println("hello " + name);
        System.out.println("Today is a nice day");
        System.out.println("How're you doing?");
        System.out.println(); // "\n"

        String someString = "some stuff here";

        //return "some string";
        //return;

        // Return an int literal. Matches return type
        return 42;

        //System.out.println("NO CODE after a return statement");
    }
}


// do not code here