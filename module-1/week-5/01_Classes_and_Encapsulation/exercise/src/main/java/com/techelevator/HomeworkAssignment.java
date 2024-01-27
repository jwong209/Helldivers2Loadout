package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    // -------- Constructor --------
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public String getLetterGrade() {                              // Derived property
        int percentage = (int)((earnedMarks / (double)possibleMarks) * 100);

        if (percentage <= 100 && percentage >= 90) {
            return "A";
        } else if (percentage <= 89 && percentage >= 80) {
            return "B";
        } else if (percentage <= 79 && percentage >= 70) {
            return "C";
        } else if (percentage <= 69 && percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // -------- Getters --------
    public int getEarnedMarks() {
        return earnedMarks;
    }
    public int getPossibleMarks() {
        return possibleMarks;
    }
    public String getSubmitterName() {
        return submitterName;
    }

    // -------- Setters --------
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }


}
