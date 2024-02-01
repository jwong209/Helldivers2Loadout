package com.techelevator._demos;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    public static void main(String[] args) {

        /*
         * Call the constructor with 1 input parameter
         */
        Car taurus = new Car(4);
        //taurus.numDoors = 4;

        /*
         * Call the constructor with 2 input parameters
         */
        Car corolla = new Car(4, "silver");

        /*
         * Call the constructor with 3 input params
         */
        Car tacoma = new Car(2, "Green", 85.0);

        /*
         * This no longer works!!!! :(
         */
        //Car pinto = new Car();
        // pinto.numDoors = ???;
        //
        //
        //

        List<Car> cars = new ArrayList<>();
        cars.add(taurus);
        cars.add(tacoma);
        cars.add(corolla);
        cars.add(new Car(4, "red"));

        Car lastCarAdded = cars.get(cars.size() - 1);

        System.out.println(corolla);
        System.out.println(corolla.toString());
    }
}
