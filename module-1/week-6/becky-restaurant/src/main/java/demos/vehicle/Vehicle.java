package demos.vehicle;

public class Vehicle {
    private String color;
    private int numWheels;

    //public Vehicle(){}

    public Vehicle(String color, int numWheels){
        this.color = color;
        this.numWheels = numWheels;
    }

    public String getColor(){
        return this.color;
    }
}
