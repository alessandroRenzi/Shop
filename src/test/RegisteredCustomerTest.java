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
		this.customer = new RegisteredCustomer("Paul David","Hewson","1960-05-10","Male","No Name Road");
	}

	@After
	public void resetId(){
		customer.resetId();
	}

	@Test
	public void testGetGenre(){
		assertEquals("Male",customer.getGenre());
	}

	@Test
	public void testGetId(){
		assertEquals("CST1",customer.getId());
	}

	@Test
	public void testGetStreet(){
		assertEquals("No Name Road",customer.getStreet());
	}

	@Test
	public void testGetAge() {
		assertEquals(56,customer.getAge());
	}

	@Test
	public void testGetName(){
		assertEquals("Paul David",customer.getName());
	}

	@Test
	public void testGetSurname(){
		assertEquals("Hewson",customer.getSurname());
	}

	@Test 
	public void toStringTest(){
		assertEquals("Name: Paul David | Surname: Hewson | Age: 56 | Genre: Male | Street: No Name Road | Id: CST1",customer.toString());
	}
}
