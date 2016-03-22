package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import customer.Customer;
import customer.UnRegisteredCustomer;
import database.Customers;

public class CustomersTest {
	private Customer customer;
	private Customers customers;
	private ByteArrayOutputStream outContent;

	@Before
	public void setUp() {
		customer = new UnRegisteredCustomer("Keith Richards","Male","1943-12-18");
		customers = new Customers();

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAddToListRegister() {
		customers.addToListRegister(customer);
		assertEquals(1,customers.getListRegister().size());
	}

	@Test
	public void testRemoveToListRegister() {
		customers.removeFromListRegister(customer);
		assertEquals(0,customers.getListRegister().size());
	}

	@Test
	public void testPrint() {
		customers.addToListRegister(customer);
		customers.print();
		assertEquals("Customers:\nNominative: Keith Richards | Genre: Male | Age: 73\n",outContent.toString());
	}
}
