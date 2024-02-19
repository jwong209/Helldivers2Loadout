package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("Enter the fully qualified name of the file that should be searched: ");
		String filePath = userInput.nextLine();
		File bookFile = new File(filePath);
		int lineCount = 1;			// changed from 0 --> 1 to align with README

		try (Scanner fileInput = new Scanner(bookFile)) {

			System.out.println("Enter the search word: ");
			String searchWord = userInput.nextLine();

			System.out.println("Should the search be case sensitive? (Y\\N)");
			String caseSensitiveInput = userInput.nextLine();

			// Loop until the end of file is reached
			while (fileInput.hasNextLine()) {

				String lineOfText = fileInput.nextLine();  // A single line of text each iteration

				if (caseSensitiveInput.equals("Y")) {
					if (lineOfText.contains(searchWord)) {
						System.out.println(lineCount + ") " + lineOfText);
					}
				} else if (caseSensitiveInput.equals("N")) {
					if (lineOfText.toLowerCase().contains(searchWord.toLowerCase())){
						System.out.println(lineCount + ") " + lineOfText);
					}
				}

				lineCount++;

			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry. File was not found: " + bookFile.getAbsolutePath());
		}
	}

}
