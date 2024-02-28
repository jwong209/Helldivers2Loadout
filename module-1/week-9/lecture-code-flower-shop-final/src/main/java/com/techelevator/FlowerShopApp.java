package com.techelevator;

public class FlowerShopApp {

	public static void main(String[] args) {

		FlowerShopOrder flowerOrder = new FlowerShopOrder("love bomb", 10);
		System.out.println(flowerOrder.subtotal());
	}

}
