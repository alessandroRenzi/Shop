package test.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import card.GoldCard;
import customer.WorkerCustomer;

public class WorkerCustomerTest {
	private WorkerCustomer customer;

	@Before
	public void setUp() {
		customer = new WorkerCustomer("Eddie van Halen","Male","1955-01-26","Eruption Road, 2","CDs and vinyls");
	}

	@Test
	public void testGetAge() {
		assertEquals(61,customer.getAge());
	}

	@Test
	public void testGetName() {
		assertEquals("Eddie van Halen",customer.getNominative());
	}

	@Test
	public void testGetGenre() {
		assertEquals("Male",customer.getGenre());
	}

	@Test
	public void testGetStreet() {
		assertEquals("Eruption Road, 2",customer.getStreet());
	}

	@Test
	public void testSetStreet() {
		customer.setStreet("Ice Cream Man Boulevard, 10");
		assertEquals("Ice Cream Man Boulevard, 10",customer.getStreet());
	}
	
	@Test 
	public void testGetWorkingArea() {
		assertEquals("CDs and vinyls",customer.getWorkingArea());
	}
	
	@Test
	public void testSetWorkingArea() {
		customer.setWorkingArea("Electronics");
		assertEquals("Electronics",customer.getWorkingArea());
	}

	@Test 
	public void testToString() {
		assertEquals("Nominative: Eddie van Halen | Genre: Male | Age: 61 | Street: Eruption Road, 2 | WorkingArea: CDs and vinyls",customer.toString());
	}

	@Test
	public void testGetCard() {
		equals(customer.getCard().equals(new GoldCard()));
	}
}

