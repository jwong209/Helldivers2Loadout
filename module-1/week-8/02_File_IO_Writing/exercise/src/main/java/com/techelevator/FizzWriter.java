package com.techelevator;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */

		System.out.println("What is the destination file?");
		String destinationPath = userInput.nextLine();
		File destinationFile = new File(destinationPath);

		try (PrintWriter writer = new PrintWriter(destinationFile)) {

//			PrintWriter writer = new PrintWriter(destinationFile); // Michael's instructions

			for (int i = 1; i <= 300; i++) {
				if (i % 5 == 0 && i % 3 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else {
					writer.println(i);
				}
			}

//			writer.flush();         //if writer is not set in try(), need to 'flush' according to Michael
			System.out.println("FizzWriter successfully wrote results to " + destinationFile);

		} catch (InvalidPathException e) {
			System.out.println("Invalid destination file path");
		} catch (FileNotFoundException e) {
			System.out.println("File was not found: " + destinationFile.getAbsolutePath());
		}

	}


}
