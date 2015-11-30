package gui;

import customer.Customer;
import database.Customers;
import item.*;
import payment.Cash;
import payment.ConcretePayment;
import payment.PayPal;
import payment.Payment;
import rentals.Rentals;
import sales.ShoppingCart;
import transaction.Transaction;

public class Main {
	public void run() {
		Customer c1 = new Customer("Matteo Gori","M",15,04,1995);
		Customer c2 = new Customer("Alessandro Renzi","M",26,04,1996);
		Customers c = new Customers();
		Item ab = new Composite("Best of Grunge - Various artists - 2015");
		Item a = new ConcreteProduct("Nevermind - Nirvana - 1991", 19.12);
		Item b = new ConcreteProduct("Ten - Pearl Jam - 1991", 7.50);
		Rentals r = new Rentals(c1,ab,22,11,2015);
		c1.addRentals(r);

		try {
			ab.add(a);
			ab.add(b);
		} catch(Exception e) {
			System.out.print("");
		}

		ShoppingCart sC1 = new ShoppingCart(c1);
		ShoppingCart sC2 = new ShoppingCart(c2);

		sC1.addToCart(ab, 1);
		sC2.addToCart(a, 1);

		c.addToListRegister(c1);
		c.addToListRegister(c2);

		for(int i = 0; i < c.getListRegister().size(); i++) {
			System.out.println(c.getListRegister().get(i));
		}

		System.out.println(sC1.toString());
		System.out.println(sC2.toString());

		Payment p1 = new ConcretePayment(sC1.getTotalPrice());
		Payment p2 = new ConcretePayment(r.rentalPriceCalc());

		Payment finalP1 = new Cash(p1);
		Payment finalP2 = new PayPal(p2);

		Transaction t1 = new Transaction(sC1,finalP1);
		Transaction t2 = new Transaction(r,finalP2);

		t1.salesTransaction();
		System.out.print("\n");
		t2.rentalEndTransaction();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}
