package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShopApp {

	public static void main(String[] args) {

//		FlowerShopOrder flowerOrder = new FlowerShopOrder("love bomb", 10);
//		System.out.println(flowerOrder.subtotal());

		List<FlowerShopOrder> flowerShopOrders = new ArrayList<>();
		BigDecimal sum = BigDecimal.ZERO;

		String filePath = "data-files/FlowerInput.csv";
		File file = new File(filePath);

		try (Scanner scanFlowerList = new Scanner(file)) {

			while (scanFlowerList.hasNextLine()) {

				String line = scanFlowerList.nextLine();
				String[] lineSplit = line.split(",");
				String type = lineSplit[0];
				int numRoses = Integer.parseInt(lineSplit[1]);

				FlowerShopOrder currentFlowerOrder = new FlowerShopOrder(type, numRoses);
				flowerShopOrders.add(currentFlowerOrder);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filePath);
		}

		for (FlowerShopOrder order : flowerShopOrders) {
			sum = sum.add(order.subtotal());
		}
		System.out.println("Total delivery cost in list: $" + sum);

	}

}
