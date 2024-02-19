package com.techelevator;

public class Quiz {
    // Create a class that can hold a quiz question, its available answers, and the correct answer.
    private String question;
    private String correctAnswer;
    private String[] possibleAnswers;


    public Quiz(String question, String correctAnswer, String[] possibleAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }
}
