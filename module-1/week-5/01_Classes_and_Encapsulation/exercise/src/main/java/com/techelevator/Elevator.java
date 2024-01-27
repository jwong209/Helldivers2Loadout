package com.techelevator;

public class Elevator {

    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    // ----------------------------- Getter -----------------------------
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    // ----------------------------- Constructor -----------------------------
    public Elevator(int numberOfLevels) {    // numberOfLevels ---> how many floors are available to the elevator
        this.numberOfFloors = numberOfLevels;
    }
    // -----------------------------

    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (doorOpen == false) {
            currentFloor++;
            if (currentFloor > numberOfFloors) currentFloor = numberOfFloors;
        }
    }

    public void goDown(int desiredFloor) {
        if (doorOpen == false) {
            currentFloor--;
            if (currentFloor < 1) currentFloor = 1;
        }
    }
}
