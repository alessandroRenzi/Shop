package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customer.WorkerCustomer;

public class WorkerCustomerTest {
	private WorkerCustomer customer;

	@Before
	public void setUp(){
		customer = new WorkerCustomer("Alessandro", "Renzi", "1985-04-26","Male","Via Belgio","Television");
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
	public void testGetWorkingArea(){
		assertEquals("Television", customer.getWorkingArea());
	}

	@Test 
	public void toStringTest(){
		assertEquals("Name: Alessandro - Surname: Renzi - Age: 31 - Genre: Male - Street: Via Belgio - WorkingArea: Television", customer.toString());
	}
}

