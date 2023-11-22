import base.ShopIF;
import semaphoreSolution.Barber;
import semaphoreSolution.Customer;
import semaphoreSolution.Shop;

public class Program {

	static String[] customerNames = { "Allen", "Bob", "Charlie", "Dennis", "Evan", "Fred", "Greg", "Hector", "Ivan",
			"John" };

	public static void main(String[] args) throws InterruptedException {

		ShopIF shop = new Shop(3); // Shop with 3 seats
		Barber barber = new Barber(shop);
		barber.start();

		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer(shop, customerNames[i]);
			customer.start();
//			Thread.sleep((long) (Math.random()*100));
		}
	}
}
