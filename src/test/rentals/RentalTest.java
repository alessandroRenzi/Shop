package test.rentals;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import item.Item;
import rentals.Rentals;
import util.rentals.GoldRentalCalc;

public class RentalTest {
	private Customer customer;
	private Item rent;
	private Rentals rental;
	private LocalDate endDate;

	@Before
	public void setUp() throws Exception {
		customer = new UnRegisteredCustomer("Alessandro Renzi", "Male", "1985-04-26");
		rent = new ConcreteProduct("Hurricane", new ConcreteCategory("DVD"), 30);
		rental = new Rentals(customer, rent, "2016-01-22");
		endDate = LocalDate.parse("2016-02-25");

		rental.setEndRentalDate(endDate);
	}

	@Test
	public void testGetGetCostumer(){
		assertEquals("Alessandro Renzi",rental.getCustomer().getNominative());
	}

	@Test
	public void testGetRentalStartDate(){
		assertTrue(rental.getRentalStartDate().isEqual(LocalDate.parse("2016-01-22")));
	}
	
	@Test
	public void testGetRentalEndDate(){
		assertTrue(rental.getEndRentalDate().isEqual(LocalDate.parse("2016-02-25")));
	}

	@Test
	public void testSetRentalStartDate(){
		rental.setRentalStartDate("1946-02-03");
		assertFalse(rental.getRentalStartDate().isEqual(LocalDate.parse("2016-01-22")));
	}

	@Test
	public void testRentalPriceCalc(){
		assertEquals(rental.rentalPriceCalc(),10.2,0.1);
	}

	@Test
	public void testSetTypeOfRental(){
		rental.setTypeOfRental(new GoldRentalCalc(endDate));
		assertEquals(rental.rentalPriceCalc(), 6.8, 0.1);
	}
}
