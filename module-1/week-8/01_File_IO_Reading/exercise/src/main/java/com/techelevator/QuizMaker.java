package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */

		System.out.println("Enter the fully qualified name of the file to read in for quiz questions: ");
		String filePathToQuiz = userInput.nextLine();
		File quizFile = new File(filePathToQuiz);

		List<Quiz> quizzes = filterQuiz(quizFile);

		for (Quiz quiz : quizzes) {

			System.out.println(quiz.getQuestion());

			String[] possibleAnswers = quiz.getPossibleAnswers();
			for (int i = 0; i < possibleAnswers.length; i++) {
				System.out.println((i + 1) + ". " + possibleAnswers[i]);
			}

			System.out.println("Your answer: ");
			String userAnswer = userInput.nextLine();

			if (userAnswer.equals(quiz.getCorrectAnswer())) {
				System.out.println("Right!");
			} else {
				System.out.println("Wrong!");
			}

		}

	}

	public List<Quiz> filterQuiz(File fileName) {

		List<Quiz> quizzes = new ArrayList<>();

		try (Scanner fileInput = new Scanner(fileName)) {

			while (fileInput.hasNextLine()) {

				String lineOfText = fileInput.nextLine();
				String[] lineSplit = lineOfText.split("\\|"); // '\' escapes 2nd '\'. 2nd '\' needed b/c '|' means 'or' in regex

				String question = lineSplit[0];
				List<String> possibleAnswersList = new ArrayList<>();  // unknown count so list is easier
				String correctAnswer = "";

				// Loop to find correct answer with *-ending while populating possibleAnswers
				for (int i = 1; i < lineSplit.length; i++) {
					if (lineSplit[i].endsWith("*")) {
						correctAnswer = lineSplit[i].replace("*", "");
						possibleAnswersList.add(correctAnswer);
					} else {
						possibleAnswersList.add(lineSplit[i]);
					}
				}

				String[] possibleAnswers = possibleAnswersList.toArray(new String[possibleAnswersList.size()]); // convert list back to array since required for Quiz constructor
				quizzes.add(new Quiz(question, correctAnswer, possibleAnswers));

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}

		return quizzes;
	}

}
