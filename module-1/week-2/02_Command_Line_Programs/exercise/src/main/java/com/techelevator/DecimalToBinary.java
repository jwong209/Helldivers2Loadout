package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String value = input.nextLine();
		String[] array = value.split(" ");

		//loop through array and invoke method for each index
		for (int i = 0; i < array.length; i++) {
			int decimalEntered = Integer.parseInt(array[i]);
			String answer = decimalToBinary(decimalEntered);
			System.out.println(decimalEntered + " in binary is " + answer);
		}
	}
	public static String decimalToBinary(int decimal) {
		long input = decimal;
		String cumulativeString = "";

		while (input > 0 ) {
			long remainder = input % 2;
			long result = input / 2;

			input = result;

			//need to convert numbers into strings
			String newDigit = String.valueOf(remainder);
			cumulativeString = newDigit + cumulativeString;
		}
		return cumulativeString;
	}

}