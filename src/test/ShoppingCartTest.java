package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.Composite;
import item.ConcreteProduct;

public class ShoppingCartTest {
	private ByteArrayOutputStream outContent;
	private Composite pack;
	private Customer customer1;
	private Customer customer2;
	private ConcreteProduct product1;
	private ConcreteProduct product2;
	private ConcreteProduct product3;
	private ShoppingCart shopCart1;
	private ShoppingCart shopCart2;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		product1 = new ConcreteProduct("Nevermind - Nirvana - 1991", "CD e Vinili", 19.12);
		product2 = new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili", 7.50);
		product3 = new ConcreteProduct("The Wall - Pink Floyd - 1979", "CD e Vinili", 30.72);

		customer1 = new UnRegisteredCustomer("Matteo Gori","M","1995-04-15");
		customer2 = new UnRegisteredCustomer("Alessandro Renzi","M","1982-1202");

		pack = new Composite("Best of Grunge - Various artists - 2015");
		try {
			pack.add(product1);
			pack.add(product2);
		} catch(Exception exception) {

		}

		shopCart1 = new ShoppingCart(customer1);
		shopCart1.addToCart(pack, 1);

		shopCart2 = new ShoppingCart(customer2);
		shopCart2.addToCart(product2, 1);
		shopCart2.addToCart(product3, 1);
	}

	@Test
	public void testGetCart() {
		assertEquals(1,shopCart1.getCart().size(),0.1);
		assertEquals(2,shopCart2.getCart().size(),0.1);
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
	public void testSetQuantityItems() {
		shopCart1.setQuantityItems(0);
		assertEquals(0,shopCart1.getQuantityItems(),0.1);

		shopCart2.setQuantityItems(1);
		assertEquals(1,shopCart2.getQuantityItems(),0.1);
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(26.62,shopCart1.getTotalPrice(),0.1);
		assertEquals(38.22,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testSetTotalPrice() {
		shopCart1.setTotalPrice(19.99);
		assertEquals(19.99,shopCart1.getTotalPrice(),0.1);

		shopCart2.setTotalPrice(82.50);
		assertEquals(82.50,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testAddToCart() {
		shopCart1.addToCart(product3, 2);
		assertEquals(3,shopCart1.getQuantityItems(),0.1);
		assertEquals(88.06,shopCart1.getTotalPrice(),0.1);

		shopCart2.addToCart(pack, 2);
		assertEquals(4,shopCart2.getQuantityItems(),0.1);
		assertEquals(91.46,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testRemoveFromCart() {
		shopCart1.removeFromCart(pack, 1);
		assertEquals(0,shopCart1.getQuantityItems(),0.1);
		assertEquals(0,shopCart1.getTotalPrice(),0.1);

		shopCart2.removeFromCart(product2, 1);
		assertEquals(1,shopCart2.getQuantityItems(),0.1);
		assertEquals(30.72,shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testPrintCart() {
		shopCart1.printCart();
		assertEquals("",outContent.toString());
	}
}
