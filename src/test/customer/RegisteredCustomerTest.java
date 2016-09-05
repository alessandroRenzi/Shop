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
	public void resetId(){
		customer.resetId();
	}
	
	@Before
	public void setUp(){
		this.customer = new RegisteredCustomer("Paul David Hewson", "Male", "1960-05-10", "Good life road, 52");
	}
	
	@Test
	public void testGetAge() {
		assertEquals(56,customer.getAge());
	}
	
	@Test
	public void testGetGenre(){
		assertEquals("Male",customer.getGenre());
	}

	@Test
	public void testGetId() {
		assertEquals("CST1",customer.getId());
	}

	@Test
	public void testGetNominative(){
		assertEquals("Paul David Hewson",customer.getNominative());
	}
	
	@Test
	public void testGetStreet(){
		assertEquals("Good life road, 52",customer.getStreet());
	}
	
	@Test
	public void testSetAge() {
		customer.setAge(20);
		assertEquals(20,customer.getAge());
	}
	
	@Test
	public void testSetCard() {
		card = new BasicCard();
		customer.setCard(card);
		assertEquals(card, customer.getCard());
	}
	
	@Test
	public void testSetGenre(){
		customer.setGenre("Female");
		assertEquals("Female",customer.getGenre());
	}
	
	@Test
	public void testSetNominative(){
		customer.setNominative("Michael Angelo Batio");
		assertEquals("Michael Angelo Batio",customer.getNominative());
	}
	
	@Test
	public void testSetStreet(){
		customer.setStreet("Afterlife Boulevard, 23");
		assertEquals("Afterlife Boulevard, 23",customer.getStreet());
	}

	@Test 
	public void toStringTest(){
		assertEquals("Nominative: Paul David Hewson | Genre: Male | Age: 56 | Street: Good life road, 52 | Id: CST1",customer.toString());
	}
}
