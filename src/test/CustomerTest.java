package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import customer.Customer;
import item.ConcreteProduct;
import rentals.Rentals;

public class CustomerTest {
	private Customer customer;
	private ByteArrayOutputStream outContent;
	private Rentals rentals;

	@Before
	public void setUp() {
		customer = new Customer("Jimi Hendrix","M",27,11,1942);

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		rentals = new Rentals(customer,new ConcreteProduct("Dookie - Green Day - 1994", 9.90),01,02,1994);
	}

	@After
	public void restore() {
		customer.resetID();
	}

	@Test
	public void testGetDateOfBirth() {
		assertEquals(27,customer.getDateOfBirth().get(Calendar.DATE));
		assertEquals(10,customer.getDateOfBirth().get(Calendar.MONTH));
		assertEquals(1942,customer.getDateOfBirth().get(Calendar.YEAR));
	}
	
	@Test
	public void testSetDateOfBirth() {
		customer.setDateOfBirth(rentals.getRentalStartDate());
		assertEquals(01,customer.getDateOfBirth().get(Calendar.DATE));
		assertEquals(01,customer.getDateOfBirth().get(Calendar.MONTH));
		assertEquals(1994,customer.getDateOfBirth().get(Calendar.YEAR));
	}

	@Test
	public void testGetGenre() {
		assertEquals("M",customer.getGenre());
	}

	@Test
	public void testSetGenre() {
		customer.setGenre("F");
		assertEquals("F",customer.getGenre());
	}

	@Test
	public void testGetID() {
		assertEquals("CST1",customer.getID());
	}

	@Test
	public void testGetNominative() {
		assertEquals("Jimi Hendrix",customer.getNominative());
	}

	@Test
	public void testSetNominative() {
		customer.setNominative("Eric Clapton");
		assertEquals("Eric Clapton",customer.getNominative());
	}
	
	@Test
	public void testToString() {
		assertEquals("Customer n.: CST1| name: Jimi Hendrix| genre: M| date of birth: 27/11/1942",customer.toString());
	}

	@Test
	public void testAddRentals() {
		customer.addRentals(rentals);
		assertEquals(1,customer.getListRentals().size());
	}

	@Test
	public void testRemoveRentals() {
		customer.removeRentals(rentals);
		assertEquals(0,customer.getListRentals().size());
	}
}
