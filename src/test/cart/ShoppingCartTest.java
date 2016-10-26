package test.cart;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.Composite;
import item.ConcreteProduct;
import item.Item;
import observer.Observer;

public class ShoppingCartTest {
	private Customer customer1;
	private Customer customer2;
	private Observer observer;
	private ByteArrayOutputStream outContent;
	private Composite pack;
	private ConcreteProduct product1;
	private ConcreteProduct product2;
	private ConcreteProduct product3;
	private ConcreteProduct product4;
	private ShoppingCart shopCart1;
	private ShoppingCart shopCart2;

	@Before
	public void setUp() throws Exception {
		this.customer1 = new UnRegisteredCustomer("Matteo Gori","M","1995-04-15");
		this.customer2 = new UnRegisteredCustomer("Alessandro Renzi","M","1985-04-25");
		
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));
		
		this.pack = new Composite("Best of Grunge - Various artists - 2015");

		this.product1 = new ConcreteProduct("Nevermind - Nirvana - 1991",  new ConcreteCategory("CD e Vinili"), 19.12);
		this.product2 = new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 7.50);
		this.product3 = new ConcreteProduct("The Wall - Pink Floyd - 1979",  new ConcreteCategory("CD e Vinili"), 30.72);
		this.product4 = new ConcreteProduct("Back in Black - ACDC - 1980", new ConcreteCategory("CD e Vinili"), 7.50);
		
		this.pack.addItem(this.product1);
		this.pack.addItem(this.product2);
		
		this.shopCart1 = new ShoppingCart(this.customer1);
		this.shopCart1.addToCart(this.pack, 1);

		this.shopCart2 = new ShoppingCart(this.customer2);			
		this.shopCart2.addToCart(this.product4, 2);
		this.shopCart2.addToCart(this.product3, 1);
	}

	@Test
	public void testGetCustomer() {
		assertEquals(this.customer1,this.shopCart1.getCustomer());
		assertEquals(this.customer2,this.shopCart2.getCustomer());
	}
	
	@Test 
	public void testGetListItemSize() {
		assertEquals(1,this.shopCart1.getQuantityItems(),0.1);
	}
	
	@Test 
	public void testGetListItemElement() throws Exception {
		Item composite = this.shopCart1.getListItem().get(0);
		String compositeDescription = composite.getDescription();
		assertEquals("Best of Grunge - Various artists - 2015",compositeDescription);
	}

	@Test
	public void testGetQuantityItems() {
		assertEquals(1,this.shopCart1.getQuantityItems(),0.1);
		assertEquals(3,this.shopCart2.getQuantityItems(),0.1);
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(26.62,this.shopCart1.getTotalPrice(),0.1);
		assertEquals(45.72,this.shopCart2.getTotalPrice(),0.1);
	}

	@Test
	public void testAddToCart1() throws Exception {
		this.shopCart1.addToCart(this.product3, 2);
		assertEquals(3,this.shopCart1.getQuantityItems(),0.1);
		assertEquals(88.06,this.shopCart1.getTotalPrice(),0.1);
	}
	
	@Test
	public void testAddToCart2() throws Exception {
		this.shopCart2.addToCart(this.pack, 2);
		assertEquals(5,this.shopCart2.getQuantityItems(),0.1);
		assertEquals(98.96,this.shopCart2.getTotalPrice(),0.1);
	}
	
	@Test
	public void testAddToCart2Again() throws Exception {
		this.shopCart2.addToCart(this.product2, 1);
		this.shopCart2.addToCart(this.product2, 1);
		assertEquals(2,this.shopCart2.getListItem().get(2).getQuantity(),0.1);
	}
	
	@Test
	public void testPrintCart() {
		this.shopCart1.printCart();
		assertEquals("Description: Best of Grunge - Various artists - 2015 | Content:\n" 
				+ "Description: Nevermind - Nirvana - 1991 | Category: CD e Vinili | Price: 19.12 | Quantity: 1" + "\n" 
				+ "Description: Ten - Pearl Jam - 1991 | Category: CD e Vinili | Price: 7.5 | Quantity: 1" + "\n\n" 
				+ "Total quantity: 1" + "\tTotal price: 26.62",this.outContent.toString());
	}

	@Test
	public void testRemoveFromCart1() throws Exception {
		this.shopCart1.removeFromCart(this.pack, 1);
		assertEquals(0,this.shopCart1.getQuantityItems(),0.1);
		assertEquals(0,this.shopCart1.getTotalPrice(),0.1);
	}
	
	@Test
	public void testRemoveFromCart2() throws Exception {
		this.shopCart2.removeFromCart(this.product2, 1);
		assertEquals(2,this.shopCart2.getQuantityItems(),0.1);
		assertEquals(38.22,this.shopCart2.getTotalPrice(),0.1);
	}

	@Test 
	public void testRemoveObserver() {
		this.shopCart1.removeObserver(this.observer);
		assertEquals(2,ShoppingCart.getListObserver().size());
	}
}
