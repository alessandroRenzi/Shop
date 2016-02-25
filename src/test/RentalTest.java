package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import customer.Customer;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import item.Item;
import rentals.Hire;
import rentals.Rentals;
import utilRentals.GoldRentalCalc;

public class RentalTest {
	Hire rental;
	Customer customer;
	Item rent;
	
	@Before
	public void setUp() throws Exception {
	customer = new UnRegisteredCustomer("Alessandro", "Renzi", "1985-04-26");
	rent = new ConcreteProduct("Hurricane", "Dvd", 30);
	rental = new Rentals(customer, rent, "2016-01-22");
	}

	@Test
	public void getRentalStartDate(){
		assertTrue(rental.getRentalStartDate().isEqual(LocalDate.parse("2016-01-22")));
	}
	
	@Test
	public void rentalPriceCalcTest(){
		assertEquals(rental.rentalPriceCalc(), 10.2,0.1);
	}
	
	@Test
	public void setTypeOfRentalTest(){
		rental.setTypeOfRental(new GoldRentalCalc());
		assertEquals(rental.rentalPriceCalc(), 6.8, 0.1);
	}

}
