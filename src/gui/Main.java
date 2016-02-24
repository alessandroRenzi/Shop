package gui;

import cart.ShoppingCart;
import customer.Customer;
import customer.UnRegisteredCustomer;
import database.Company;
import invoice.ConcreteInvoice;
import invoice.Invoice;
import item.Composite;
import item.ConcreteProduct;

public class Main {
	public void run() {
		ConcreteProduct product1 = new ConcreteProduct("Nevermind - Nirvana - 1991", "CD e Vinili", 19.12);
		ConcreteProduct product2 = new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili", 7.50);
		ConcreteProduct product3 = new ConcreteProduct("The Wall - Pink Floyd - 1979", "CD e Vinili", 30.72);

		Customer customer1 = new UnRegisteredCustomer("Matteo Gori","M","1995-04-12");
		Customer customer2 = new UnRegisteredCustomer("Alessandro Renzi","M","1985-04-26");

		Composite pack = new Composite("Best of Grunge - Various artists - 2015");
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception exception) { }

		Company company = new Company();
		
		ShoppingCart shopCart1 = new ShoppingCart(customer1);
		shopCart1.addToCart(pack, 1);

		ShoppingCart shopCart2 = new ShoppingCart(customer2);
		shopCart2.addToCart(product2, 1);
		shopCart2.addToCart(product3, 1);
		
		Invoice i = new ConcreteInvoice(shopCart1);
		i.doInvoice();
		
		company.printCompanyInfo();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}