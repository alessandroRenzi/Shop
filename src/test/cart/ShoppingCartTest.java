package test.cart;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import cart.Cart;
import cart.ShoppingCart;
import cart.ShoppingCartObserver;
import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.Composite;
import item.ConcreteProduct;
import observer.Observer;
import observer.TotalPrice;

public class ShoppingCartTest {
	private Customer customer1;
	private Customer customer2;
	private Observer observer;
	private ByteArrayOutputStream outContent;
	private Composite pack;
	private ConcreteProduct product1;
	private ConcreteProduct product2;
	private ConcreteProduct product3;
	private ShoppingCart shopCart1;
	private Cart shopCart2;

	@Before
	public void setUp() {
		customer1 = new UnRegisteredCustomer("Matteo Gori","M","1995-04-15");
		customer2 = new UnRegisteredCustomer("Alessandro Renzi","M","1982-12-02");
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		pack = new Composite("Best of Grunge - Various artists - 2015");

		product1 = new ConcreteProduct("Nevermind - Nirvana - 1991",  new ConcreteCategory("CD e Vinili"), 19.12);
		product2 = new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 7.50);
		product3 = new ConcreteProduct("The Wall - Pink Floyd - 1979",  new ConcreteCategory("CD e Vinili"), 30.72);
		
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception e) {}
		
		shopCart1 = new ShoppingCart(customer1);
		try {
			shopCart1.addToCart(pack, 1);
		} catch(Exception e) {}
		
		observer = new TotalPrice(shopCart1);
		shopCart1.addObserver(observer);

		shopCart2 = new ShoppingCart(customer2);
		try {
			shopCart2.addToCart(product2, 1);
		} catch(Exception e) {}
		try {
			shopCart2.addToCart(product3, 1);
		} catch(Exception e) {}
	}

	@Test
	public void testGetCustomer() {
		assertEquals(customer1,shopCart1.getCustomer());
		assertEquals(customer2,shopCart2.getCustomer());
	}

	@Test
	public void testGetQuantityItems() {
		assertEquals(1,shopCart1.getQuantityItems(),0.1);
		assertEquals(2,shopCart2.getQuantityItems(),0.1);
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(26.62,shopCart1.getTotalPrice(),0.1);
		assertEquals(38.22,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testSetQuantityItems() throws Exception{
		shopCart1.setQuantityItems(0);
		assertEquals(0,shopCart1.getQuantityItems(),0.1);

		shopCart2.setQuantityItems(1);
		assertEquals(1,shopCart2.getQuantityItems(),0.1);
	}

	@Test
	public void testSetTotalPrice() {
		shopCart1.setTotalPrice(19.99);
		assertEquals(19.99,shopCart1.getTotalPrice(),0.1);

		shopCart2.setTotalPrice(82.50);
		assertEquals(82.50,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testAddToCart1() throws Exception {
		shopCart1.addToCart(product3, 2);
		assertEquals(3,shopCart1.getQuantityItems(),0.1);
		assertEquals(88.06,shopCart1.getTotalPrice(),0.1);
	}
	
	@Test
	public void testAddToCart2() throws Exception {
		shopCart2.addToCart(pack, 2);
		assertEquals(4,shopCart2.getQuantityItems(),0.1);
		assertEquals(91.46,shopCart2.getTotalPrice(),0.1);
	}
	
	@Test
	public void testAddToCart2Again() throws Exception {
		shopCart2.addToCart(product2, 2);
		assertEquals(4,shopCart2.getQuantityItems(),0.1);
		assertEquals(53.22,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testRemoveFromCart1() throws Exception {
		shopCart1.removeFromCart(pack, 1);
		assertEquals(0,shopCart1.getQuantityItems(),0.1);
		assertEquals(0,shopCart1.getTotalPrice(),0.1);
	}
	
	@Test
	public void testRemoveFromCart2() throws Exception {
		shopCart2.removeFromCart(product2, 1);
		assertEquals(1,shopCart2.getQuantityItems(),0.1);
		assertEquals(30.72,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testPrintCart() {
		shopCart1.printCart();
		assertEquals("Description: Best of Grunge - Various artists - 2015 | Content:\n" 
				+ "Description: Nevermind - Nirvana - 1991 | Category: CD e Vinili | Price: 19.12 | Quantity: 1" + "\n" 
				+ "Description: Ten - Pearl Jam - 1991 | Category: CD e Vinili | Price: 7.5 | Quantity: 1" + "\n\n" 
				+ "Total quantity: 1" + "\tTotal price: 26.62",outContent.toString());
	}

	@Test 
	public void testRemoveObserver() {
		shopCart1.removeObserver(observer);
		assertEquals(2, ShoppingCartObserver.getListObserver().size());
	}

	@Test 
	public void testGetItemIterator() {
		shopCart1.getItemIterator();
	}
}
