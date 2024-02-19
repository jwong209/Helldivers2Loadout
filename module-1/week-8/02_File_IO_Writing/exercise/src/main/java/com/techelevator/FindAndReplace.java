package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourcePath = userInput.nextLine();
        File sourceFile = new File(sourcePath);

        System.out.println("What is the destination file?");
        String destinationPath = userInput.nextLine();
        File destinationFile = new File(destinationPath);


        try (Scanner fileInput = new Scanner(sourceFile); PrintWriter writer = new PrintWriter(destinationFile)) {

            while (fileInput.hasNextLine()) {                      // Loop until the end of file is reached
                String lineOfText = fileInput.nextLine();

                if (lineOfText.contains(searchWord)) {
                    String replacedLine = lineOfText.replaceAll(searchWord, replacementWord);
                    writer.println(replacedLine);
                } else {
                    writer.println(lineOfText);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Source file was not found: " + sourceFile.getAbsolutePath());

        }


    }


}
