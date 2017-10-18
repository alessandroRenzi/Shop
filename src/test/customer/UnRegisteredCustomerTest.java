package test.customer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customer.AbstractCustomer;
import customer.UnRegisteredCustomer;

public class UnRegisteredCustomerTest {
	private AbstractCustomer customer;

	@Before
	public void setUp(){
		this.customer = new UnRegisteredCustomer("Alessandro Renzi", "Male", "1985-04-26");
	}

	@Test
	public void testGetAge() {
		assertEquals(32, this.customer.getAge());
	}

	@Test
	public void testGetName(){
		assertEquals("Alessandro Renzi", this.customer.getNominative());
	}

	@Test
	public void testGetSurname(){
		assertEquals("Male", this.customer.getGenre());
	}

	@Test 
	public void testToString(){
		assertEquals("Nominative: Alessandro Renzi | Genre: Male | Age: 32", this.customer.toString());
	}
}
