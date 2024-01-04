package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length: ");
		String value = input.nextLine();
		int lengthGiven = Integer.parseInt(value);

		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		value = input.nextLine();
		String unitOfMeasurement = value;

		int resultInFeet = meterToFoot(lengthGiven);
		int resultInMeters = footToMeter(lengthGiven);

		if (unitOfMeasurement.equals("m")) {
			System.out.println(lengthGiven + "m" + " is " + resultInFeet + "f");
		}
		if (unitOfMeasurement.equals("f")) {
			System.out.println(lengthGiven + "f" + " is " + resultInMeters + "m");
		}
	}

	public static int footToMeter(int length) {
		return (int)(length * 0.3048);
	}
	public static int meterToFoot(int length) {
		return (int)(length * 3.2808399);
	}

}
