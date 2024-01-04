package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a number: ");
		String value = input.nextLine();
		int numberEntered = Integer.parseInt(value);


		Fibonacci(numberEntered);
	}
	public static void Fibonacci(int number) {
		//Take edge cases of 0 and 1 first
		if (number == 0) {
			System.out.println("0, 1");
		}
		if (number == 1) {
			System.out.println("0, 1, 1");
		}
		//General operations
		if (number > 1) {
			int first = 0;
			int second = 1;
			String result = "";

			for (int i = 0; i <= number; i++) {
//				System.out.println(first);
				result += first + ", ";

				int next = first + second;
				first = second;
				second = next;

				if (next > number) {
//					System.out.println(first);
					result += first;
					break;
				}
			}
			System.out.println(result);
		}
	}
}
