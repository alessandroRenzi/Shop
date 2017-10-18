package test.customer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import card.BasicCard;
import card.Card;
import customer.RegisteredCustomer;

public class RegisteredCustomerTest {
	private RegisteredCustomer customer;
	private Card card;

	@After
	public void resetId() {
		this.customer.resetId();
	}
	
	@Before
	public void setUp() {
		this.customer = new RegisteredCustomer("Paul David Hewson", "Male", "1960-05-10", "Good life road, 52");
	}
	
	@Test
	public void testGetAge() {
		assertEquals(57, this.customer.getAge());
	} 
	
	@Test
	public void testGetBirthDay() {
		assertEquals("1960-05-10", this.customer.getBirthDay().toString());
	}
	
	@Test
	public void testGetGenre() {
		assertEquals("Male", this.customer.getGenre());
	}

	@Test
	public void testGetId() {
		assertEquals("CST1", this.customer.getId());
	}

	@Test
	public void testGetNominative() {
		assertEquals("Paul David Hewson", this.customer.getNominative());
	}
	
	@Test
	public void testGetStreet() {
		assertEquals("Good life road, 52", this.customer.getStreet());
	}
	
	@Test
	public void testSetAge() {
		this.customer.setAge(20);
		assertEquals(20, this.customer.getAge());
	}
	
	@Test
	public void testSetBirthDay() {
		this.customer.setBirthDay("1959-05-10");
		assertEquals("1959-05-10", this.customer.getBirthDay().toString());
	}
	
	@Test
	public void testSetCard() {
		this.card = new BasicCard();
		this.customer.setCard(this.card);
		assertEquals(this.card, this.customer.getCard());
	}
	
	@Test
	public void testSetGenre() {
		this.customer.setGenre("Female");
		assertEquals("Female", this.customer.getGenre());
	}
	
	@Test
	public void testSetNominative() {
		this.customer.setNominative("Michael Angelo Batio");
		assertEquals("Michael Angelo Batio", this.customer.getNominative());
	}
	
	@Test
	public void testSetStreet() {
		this.customer.setStreet("Afterlife Boulevard, 23");
		assertEquals("Afterlife Boulevard, 23", this.customer.getStreet());
	}

	@Test 
	public void toStringTest() {
		assertEquals("Nominative: Paul David Hewson | Genre: Male | Age: 57 | Street: Good life road, 52 | Id: CST1", this.customer.toString());
	}
}
