package com.techelevator;

public class HotelReservation {
    /*
    Fill in the class details here...
     */
    private String name;
    private int numberOfNights;
    private int nightlyRate;

    //  ----- Constructor -----
    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    //  ----- Getters -----
    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    //  ----- Setters -----
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    //  ----- Method -----
    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar) {

        int actualTotal = getEstimatedTotal();  // Start with the value of estimatedTotal
        int cleaningFee = 0;

        if (requiresCleaning) {  // If requiresCleaning is true, add a cleaning fee of $25.
            cleaningFee += 25;
        }

        if (usedMinibar) {  //If usedMinibar is true, add a mini-bar fee of $15, and double the cleaning fee
            actualTotal += 15;
            cleaningFee *= 2;

        }

        actualTotal += cleaningFee;

        return actualTotal;
    }

    @Override
    public String toString() {
        return getName() + ":" + getEstimatedTotal();
    }

}
