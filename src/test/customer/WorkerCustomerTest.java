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
		this.customer = new WorkerCustomer("Eddie van Halen","Male","1955-01-26","Eruption Road, 2","CDs and vinyls");
	}

	@Test
	public void testGetAge() {
		assertEquals(62, this.customer.getAge());
	}

	@Test
	public void testGetName() {
		assertEquals("Eddie van Halen", this.customer.getNominative());
	}

	@Test
	public void testGetGenre() {
		assertEquals("Male", this.customer.getGenre());
	}

	@Test
	public void testGetStreet() {
		assertEquals("Eruption Road, 2", this.customer.getStreet());
	}

	@Test
	public void testSetStreet() {
		this.customer.setStreet("Ice Cream Man Boulevard, 10");
		assertEquals("Ice Cream Man Boulevard, 10", this.customer.getStreet());
	}
	
	@Test 
	public void testGetWorkingArea() {
		assertEquals("CDs and vinyls", this.customer.getWorkingArea());
	}
	
	@Test
	public void testSetWorkingArea() {
		this.customer.setWorkingArea("Electronics");
		assertEquals("Electronics", this.customer.getWorkingArea());
	}

	@Test 
	public void testToString() {
		assertEquals("Nominative: Eddie van Halen | Genre: Male | Age: 62 | Street: Eruption Road, 2 | WorkingArea: CDs and vinyls", this.customer.toString());
	}

	@Test
	public void testGetCard() {
		equals(customer.getCard().equals(new GoldCard()));
	}
}

