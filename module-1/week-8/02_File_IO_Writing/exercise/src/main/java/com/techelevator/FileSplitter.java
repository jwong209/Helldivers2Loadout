package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FileSplitter fileSplitter = new FileSplitter();
		fileSplitter.run();
	}

	public void run() {
		/* Your code goes here */

		System.out.print("Where is the input file (please include the path to the file)? ");
		String inputFilePath = userInput.nextLine();

		System.out.print("How many lines of text (max) should there be in the split files? ");
		int maxLines = userInput.nextInt();

		try (Scanner fileScanner = new Scanner(new File(inputFilePath))) {
			int fileCounter = 1;
			int lineCounter = 0;

			while (fileScanner.hasNextLine()) {
				String outputFilePath = "input-" + fileCounter + ".txt";
				PrintWriter writer = new PrintWriter(outputFilePath);

				for (int i = 0; i < maxLines && fileScanner.hasNextLine(); i++) {
					writer.println(fileScanner.nextLine());
					lineCounter++;
				}

				writer.close();
				System.out.println("Generating " + outputFilePath);
				fileCounter++;
			}

			System.out.println("\nTotal lines processed: " + lineCounter);
			System.out.println("Total output files created: " + (fileCounter - 1));

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + inputFilePath);
		}


	}

}
