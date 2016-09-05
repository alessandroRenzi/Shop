package test.item;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import discount.SummerDiscount;
import item.ConcreteProduct;
import item.DecoratedProduct;
import item.Product;

public class DecoratedProductTest {
	private ByteArrayOutputStream outContent;
	private DecoratedProduct decoratedProduct;
	private Product product;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		product = new ConcreteProduct("Green River - Creedence Clearwater Revival - 1969",  new ConcreteCategory("CD & Vinyl"), 23.49);
		decoratedProduct = new DecoratedProduct(product, 10);
	}
	
	@Test
	public void testGetCategory() {
		new ConcreteCategory("CD & Vinyl").equals(decoratedProduct.getCategory());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("Green River - Creedence Clearwater Revival - 1969", decoratedProduct.getDescription());
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals("Base discount", decoratedProduct.getDiscount().toString());
	}

	@Test
	public void testGetPrice() {
		assertEquals(21.141, decoratedProduct.getPrice(), 0.1);
	}
	
	@Test
	public void testGetQuantity() {
		assertEquals(1, decoratedProduct.getQuantity());
	}

	@Test
	public void testPrint() {
		decoratedProduct.printItem();
		assertEquals("Description: Green River - Creedence Clearwater Revival - 1969 | "
				+ "Category: CD & Vinyl | Price: 23.49 | Quantity: 1 | Discount: 10% | Discounted price: "
				+ "21.14", outContent.toString());
	}
	
	@Test
	public void testSetDiscount() {
		decoratedProduct.setDiscount(new SummerDiscount(30));
		assertEquals(14.7987,decoratedProduct.getPrice(),0.1);
	}
	
	@Test
	public void testSetPercentage() {
		decoratedProduct.setPercentage(5);
		assertEquals(22.315, decoratedProduct.getPrice(), 0.1);
	}
	
	@Test
	public void testSetQuantity() {
		decoratedProduct.setQuantity(2);
		assertEquals(2, decoratedProduct.getQuantity(), 0.1);
	}
	
	@Test
	public void testToString() {
		assertEquals("Description: Green River - Creedence Clearwater Revival - 1969 | "
				+ "Category: CD & Vinyl | Price: 23.49 | Quantity: 1 | Discount: 10% | Discounted price: "
				+ "21.14", decoratedProduct.toString());
	}
}
