package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */
    private String name; // defaults to null
    private boolean open; // defaults to 'false'
    private int numberOfCompactSlots;  //defaults to 0
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;

//    Car[] compactList = new Car[numberOfCompactSlots];
//    Car[] midsizeList = new Car[numberOfMidsizeSlots];
//    Car[] fullsizeList = new Car[numberOfFullsizeSlots];

    List<Car> compactList = new ArrayList<>();  // represents # parked? need lists to keep track of parked cars
    List<Car> midsizeList = new ArrayList<>();
    List<Car> fullsizeList = new ArrayList<>();

    // Constructor (should be 3)
    public ParkingLot(String name) {
        this.name = name;
        numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;
        numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    // Getters (should be 6)
    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    // Setters (just 1)
    public void setOpen(boolean open) {
        this.open = open;
    }

    // methods
    public int numberOfAvailableSlots(String carType) {

        //difference between the number of slots for a given car type slot and the number of cars already parked in those slots.
        if (carType.equals("compact")) {
            return numberOfCompactSlots - compactList.size();
        } else if (carType.equals("midsize")) {
            return numberOfMidsizeSlots - midsizeList.size();
        } else {
            return numberOfFullsizeSlots - fullsizeList.size();
        }

    }

    public boolean park(Car car) throws ParkingLotException {

        if (!open) {
            throw new ParkingLotException("No parking available");
        }

        if (open) {
            if (car.getType().equals("compact")&& compactList.size() < numberOfCompactSlots) {   //successfully parked
                compactList.add(car);
                return true;
            } else if (car.getType().equals("midsize") && midsizeList.size() < numberOfMidsizeSlots) {
                midsizeList.add(car);
                return true;
            } else if (car.getType().equals("fullsize") && fullsizeList.size() < numberOfFullsizeSlots) {
                fullsizeList.add(car);
                return true;
            }
        }

        return false;

    }

    public Car exit(String license) {

        // loop through all lists to find matching license, returns Car if found
        for (Car car : compactList) {
            if (car.getLicense().equals(license)) {
                compactList.remove(car);
                return car;
            }
        }
        for (Car car : midsizeList) {
            if (car.getLicense().equals(license)) {
                midsizeList.remove(car);
                return car;
            }
        }
        for (Car car : fullsizeList) {
            if (car.getLicense().equals(license)) {
                fullsizeList.remove(car);
                return car;
            }
        }

        return null;
    }


}
