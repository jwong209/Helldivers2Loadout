// Car.java
public class Car {
    private String make;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setMake("Ford");
        Car car2 = new Car();
        car2.setMake("Ford");

        System.out.println(car1.equals(car2));
    }
}

