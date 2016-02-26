package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import customer.Customer;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import item.Item;
import payment.ConcretePayment;
import payment.PayPal;
import payment.Payment;
import rentals.Hire;
import rentals.Rentals;
import transaction.RentalTransaction;
import transaction.Transaction;

public class RentalTransactionTest {
	Customer customer;
	Item rent;
	Hire rental;
	Payment kindPayment;
	Transaction transaction;
	LocalDate date;
	
	@Before
	public void setUp() throws Exception {
	rent = new ConcreteProduct("Hurricane", "Dvd", 30);
	customer = new UnRegisteredCustomer("Alessandro", "Renzi", "1985-04-26");
	rental = new Rentals(customer, rent, "2016-01-22");
	date = LocalDate.parse("2016-02-25");
	rental.setEndRentalDate(date);
	kindPayment = new PayPal(new ConcretePayment(rental.rentalPriceCalc()));
	transaction = new RentalTransaction(kindPayment, rental);
	
	}
	
	@Test
	public void salesTransactionTest(){
		transaction.salesTransaction();
		assertEquals("Paid by PayPal: 10.2" ,transaction.getTransaction());
	}

}
