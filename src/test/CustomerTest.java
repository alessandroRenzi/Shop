package test;

import static org.junit.Assert.*;

import org.junit.Test;

import customer.Customer;

public class CustomerTest {
	private Customer customer1 = new Customer("Matteo Gori","M",1995,04,15);
	private Customer customer2 = new Customer("Alessandro Renzi","M",1982,12,02);

	//private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//System.setOut(new PrintStream(outContent));

	//	@Before
	//	public void setUp() {
	//		customer1 = new Customer("Matteo Gori","M",1995,04,15);
	//		customer2 = new Customer("Alessandro Renzi","M",1982,12,02);
	//
	//		outContent = new ByteArrayOutputStream();
	//		System.setOut(new PrintStream(outContent));
	//	}

	@Test
	public void testGetGenre() {
		assertEquals("M",customer1.getGenre());
	}

	@Test
	public void testSetGenre() {
		customer1.setGenre("F");
		assertEquals("F",customer1.getGenre());
	}

//	@Test
//	public void testGetID() {
//		assertEquals("CST1",customer1.getID());
//		assertEquals("CST2",customer2.getID());
//	}

	@Test
	public void testGetNominative() {
		assertEquals("Matteo Gori",customer1.getNominative());
		assertEquals("Alessandro Renzi",customer2.getNominative());
	}

	@Test
	public void testSetNominative() {
		customer1.setNominative("Alessandro Renzi");
		assertEquals("Alessandro Renzi",customer1.getNominative());

		customer2.setNominative("Matteo Gori");
		assertEquals("Matteo Gori",customer2.getNominative());
	}
}
