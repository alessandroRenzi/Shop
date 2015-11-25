package transaction;

import payment.Payment;
import rentals.Rentals;
import sales.ShoppingCart;
//import utility.ConcreteInvoice;

public class Transaction {
	//private ConcreteInvoice invoice; 
	private Payment payment;
	private Rentals rentals;
	private ShoppingCart shoppingCart;

	public Transaction(ShoppingCart shoppingCart, Payment payment) {
		this.payment = payment;
		this.shoppingCart = shoppingCart;
	}

	public Transaction(Rentals rentals, Payment payment) {
		this.payment = payment;
		this.rentals = rentals;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Rentals getRentals() {
		return rentals;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void salesTransaction() {
		this.payment.doPay();
	}

	public void rentalEndTransaction() {
		this.payment.doPay();
	}
}
