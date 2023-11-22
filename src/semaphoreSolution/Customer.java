package semaphoreSolution;

import base.ShopIF;

public class Customer extends Thread {

	private ShopIF shop;
	private String name;

	public Customer(ShopIF shop, String name) {
		this.shop = shop;
		this.name = name;
	}

	public void run() {
		System.out.println(name + " enters shop");
		if (shop.enter()) {
			System.out.println(name + " is getting a haircut");
			shop.leave();
		} else {
			System.out.println("No chair available for " + name);
		}
		System.out.println(name + " leaves shop");
	}
}
