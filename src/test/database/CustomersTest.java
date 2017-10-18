package test.database;

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
		this.customer = new UnRegisteredCustomer("Keith Richards","Male","1943-12-18");
		this.customers = new Customers();

		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));
	}

	@Test
	public void testAddToListRegister() {
		this.customers.addToListRegister(this.customer);
		assertEquals(1,this.customers.getListRegister().size());
	}

	@Test
	public void testRemoveToListRegister() {
		this.customers.removeFromListRegister(this.customer);
		assertEquals(0,this.customers.getListRegister().size());
	}

	@Test
	public void testPrint() {
		this.customers.addToListRegister(customer);
		this.customers.print();
		assertEquals("Customers:\nNominative: Keith Richards | Genre: Male | Age: 74\n",this.outContent.toString());
	}
}
