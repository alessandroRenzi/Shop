package gui;

import cart.ShoppingCart;
import customer.Customer;
import customer.UnRegisteredCustomer;
import customer.WorkerCustomer;
import item.Composite;
import item.ConcreteProduct;

public class Main {
	public void run() {
		ConcreteProduct product1 = new ConcreteProduct("Nevermind - Nirvana - 1991", "CD e Vinili", 19.12);
		ConcreteProduct product2 = new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili", 7.50);
		ConcreteProduct product3 = new ConcreteProduct("The Wall - Pink Floyd - 1979", "CD e Vinili", 30.72);

		Customer customer1 = new WorkerCustomer("Matteo","Gori","1995-04-12","M","Via Federico Zoi, 18","UniFi");
		Customer customer2 = new UnRegisteredCustomer("Alessandro Renzi","M","1985-04-26");

		Composite pack = new Composite("Best of Grunge - Various artists - 2015");
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception exception) { }

		ShoppingCart shopCart1 = new ShoppingCart(customer1);
		shopCart1.addToCart(pack, 1);

		ShoppingCart shopCart2 = new ShoppingCart(customer2);
		System.out.println(shopCart2.getTotalPrice());
		//System.out.println(shopCart2.getQuantityItems());
		shopCart2.addToCart(product2, 1);
		System.out.println(shopCart2.getTotalPrice());
		//System.out.println(shopCart2.getQuantityItems());
		shopCart2.addToCart(product3, 1);
		System.out.println(shopCart2.getTotalPrice());
		//System.out.println(shopCart2.getQuantityItems());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}