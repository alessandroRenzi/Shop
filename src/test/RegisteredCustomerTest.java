package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import customer.RegisteredCustomer;


public class RegisteredCustomerTest {
	private RegisteredCustomer customer;


	@Before
	public void setUp(){
		this.customer = new RegisteredCustomer("Alessandro", "Renzi", "1985-04-26","Male","Via Belgio");
	}

	@After
	public void resetId(){
		customer.resetId();
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
	public void testGetGenre(){
		assertEquals("Male", customer.getGenre());
	}
	@Test
	public void testGetStreet(){
		assertEquals("Via Belgio", customer.getStreet());
	}
	@Test 
	public void toStringTest(){
		assertEquals("Name: Alessandro Surname: Renzi Age: 31 Genre: Male Street: Via Belgio Id: CST1", customer.toString());
	}
}
