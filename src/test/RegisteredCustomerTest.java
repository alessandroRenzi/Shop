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
		this.customer = new RegisteredCustomer("Paul David Hewson","Male","1960-05-10","Good life road, 69");
	}

	@After
	public void resetId(){
		customer.resetId();
	}

	@Test
	public void testGetId(){
		assertEquals("CST1",customer.getId());
	}

	@Test
	public void testGetStreet(){
		assertEquals("Good life road, 69",customer.getStreet());
	}
	
	@Test
	public void testSetStreet(){
		customer.setStreet("Afterlife Boulevard, 23");
		assertEquals("Afterlife Boulevard, 23",customer.getStreet());
	}

	@Test
	public void testGetAge() {
		assertEquals(56,customer.getAge());
	}

	@Test
	public void testGetNominative(){
		assertEquals("Paul David Hewson",customer.getNominative());
	}

	@Test
	public void testGetSGenre(){
		assertEquals("Male",customer.getGenre());
	}

	@Test 
	public void toStringTest(){
		assertEquals("Nominative: Paul David Hewson | Genre: Male | Age: 56 | Street: Good life road, 69 | Id: CST1",customer.toString());
	}
}
