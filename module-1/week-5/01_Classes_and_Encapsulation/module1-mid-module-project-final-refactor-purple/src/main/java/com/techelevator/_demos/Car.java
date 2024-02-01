package com.techelevator._demos;

public class Car {
    int numDoors;
    String color;
    double engineSize;

    /*
     * 1 input constructor
     */
    public Car(int numDoors){
        this.numDoors = numDoors;
    }

    /*
     * 2 input constructor
     */
    public Car(int numDoors, String color){
        this.numDoors = numDoors;
        this.color = color;
    }

    /*
     * 3 input constructor
     */
    public Car(int numDoors, String color, double engineSize){
        this.numDoors = numDoors;
        this.color = color;
        this.engineSize = engineSize;
    }

    public int getNumDoors(){
        return numDoors;
    }

    @Override
    public String toString(){
        return "This car is " + color + " and has " + numDoors + " doors" ;
    }
}
