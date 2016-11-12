package test.transaction;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import item.Item;
import payment.Cash;
import payment.ConcretePayment;
import payment.PayPal;
import payment.Payment;
import rentals.Hire;
import rentals.Rentals;
import transaction.RentalTransaction;
import transaction.Transaction;

public class RentalTransactionTest {
	private Customer customer;
	private LocalDate date;
	private Payment kindPayment;
	private Item rent;
	private Hire rental;
	private Transaction transaction;
	
	@Before
	public void setUp() throws Exception {
		this.customer = new UnRegisteredCustomer("Jerry", "Cantrell", "1966-03-18");
		this.date = LocalDate.parse("2016-09-02");
		this.rent = new ConcreteProduct("Hurricane",  new ConcreteCategory("DVD"), 30);
		
		this.rental = new Rentals(customer, rent, "2016-01-22");
		this.rental.setEndRentalDate(date);
		this.kindPayment = new PayPal(new ConcretePayment(rental.rentalPriceCalc()));
		this.transaction = new RentalTransaction(kindPayment, rental);
	}
	
	@Test
	public void testSalesTransactionTest(){
		this.transaction.salesTransaction();
		assertEquals("Paid by PayPal: 67.2",transaction.getTransaction());
	}
	
	@Test
	public void testSetPayment() {
		this.transaction.setPayment(new Cash(new ConcretePayment(this.rental.rentalPriceCalc())));
		this.transaction.salesTransaction();
		assertEquals("Paid in cash: 67.2",transaction.getTransaction());
	}
}
