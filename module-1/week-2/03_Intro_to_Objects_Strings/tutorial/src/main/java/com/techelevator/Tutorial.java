package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class Tutorial {

    public static void main(String[] args) {

        // ***********  Step 1: Use the *new* operator to create Strings on the Heap  *************
        char[] helloChars = new char[] {'h', 'e', 'l', 'l', 'o', '!'};
        String greeting = new String(helloChars);
        System.out.println("Greeting: " + greeting);

        String salutation = new String("Welcome my friend");
        System.out.println("Salutation: " + salutation);

        String toast = "May the compiler rise up to meet you.";
        System.out.println("Toast: " + toast);


        // ***********  Step 2: Try out some String methods  *************
        System.out.println("Please type a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        System.out.println(sentence);

                // --------------------
        String uppercaseSentence = sentence.toUpperCase();
        System.out.println(uppercaseSentence);
        System.out.println(sentence.toLowerCase());

                // --------------------

        int firstSpace = sentence.indexOf(" ");

        if (firstSpace == -1) {
            System.out.println("The first word is " + sentence.length() + " characters long.");
        } else {
            System.out.println("The first word is " + firstSpace + " characters long.");
        }
                // --------------------
        System.out.println(sentence.replace("the", "the one and only"));

                // --------------------
        String[] words = sentence.split(" ");
        System.out.println("The words in this sentence:");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        String dashSentence = String.join("-->", words);
        System.out.println(dashSentence);

                // --------------------
        System.out.println(sentence);


        // ***********  Step 3: Compare Strings  *************
        String secretWord = "Secret!";
        System.out.println("Enter the secret word (hint: it's '" + secretWord + "') ");
        String userSecretWord = scanner.nextLine();

        boolean matchEqualityOperator = secretWord == userSecretWord;
        System.out.println("Using '--': " + matchEqualityOperator);

        boolean matchEquals = secretWord.equals(userSecretWord);
        System.out.println("Using '.equals(): " + matchEquals);

        boolean matchEqualsIgnoreCase = secretWord.equalsIgnoreCase(userSecretWord);
        System.out.println("Using '.equalsIgnoreCase(): " + matchEqualsIgnoreCase);
    }
}
