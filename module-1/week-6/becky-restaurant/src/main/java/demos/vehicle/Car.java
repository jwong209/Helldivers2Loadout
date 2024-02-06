package demos.vehicle;

public class Car extends Vehicle implements Drivable {
    public Car(String color, int numWheels) {
        super(color, numWheels);
    }

    @Override
    public void drive() {

    }

    public void park(){
        System.out.println("Parking...");
    }

    //@Override
    public void brake(){}

//    public Car(){
//        super("silver", 4);
//    }
}
