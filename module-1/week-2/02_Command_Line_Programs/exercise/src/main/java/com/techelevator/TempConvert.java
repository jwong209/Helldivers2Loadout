package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String value = input.nextLine();
		int temperature = Integer.parseInt(value);

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String temperatureScale = input.nextLine();

		int resultInFahrenheit = celsiusToFahrenheit(temperature);
		int resultInCelsius = fahrenheitToCelsius(temperature);

		//If temperature given is in Celsius, then calculate to Fahrenheit
		if (temperatureScale.equals("C")) {
			System.out.print(temperature + temperatureScale + " is " + resultInFahrenheit + "F");
		}
		//If temperature given is in Fahrenheit, then calculate to Celsius
		if (temperatureScale.equals("F")) {
			System.out.println(temperature + temperatureScale + " is " + resultInCelsius + "C");
		}


	}

	public static int fahrenheitToCelsius(int temperature) {
		int temperatureCelsius = (int)((temperature - 32) / 1.8);
		return temperatureCelsius;
	}
	public static int celsiusToFahrenheit(int temperature) {
		int temperatureFahrenheit = (int)((temperature * 1.8) + 32);
		return temperatureFahrenheit;
	}
}
