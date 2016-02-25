package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customer.AbstractCustomer;
import customer.UnRegisteredCustomer;

public class UnRegisteredCustomerTest {
	private AbstractCustomer customer;


	@Before
	public void setUp(){
		this.customer = new UnRegisteredCustomer("Alessandro", "Renzi", "1985-04-26");
	}

	@Test
	public void testGetAge() {
		assertEquals(31, customer.getAge());
	}

	@Test
	public void testGetName(){
		assertEquals("Alessandro", customer.getName());
	}

	@Test
	public void testGetSurname(){
		assertEquals("Renzi", customer.getSurname());
	}

	@Test 
	public void toStringTest(){
		assertEquals("Name: Alessandro - Surname: Renzi - Age: 31", customer.toString());
	}


}
