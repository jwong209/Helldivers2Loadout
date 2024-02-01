package com.techelevator._demos;

public class HwAssignment {

    int possibleMarks;
    int earnedMarks;


    /*
     * Need a way to make sure that possibleMarks is always set
     * b/c no assignment will ever has a possible marks of 0
     */
    public HwAssignment(int possibleMarks){
        this.possibleMarks = possibleMarks;
    }

    public double getPercentage(){
        return this.earnedMarks / this.possibleMarks;
    }

    public void setEarnedMarks(int marks) {
        this.earnedMarks = marks;
    }
}
