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
import report.MaxVisitor;
import report.Visitor;

public class DecoratedProductTest {
	private DecoratedProduct decoratedProduct1;
	private DecoratedProduct decoratedProduct2;
	private ByteArrayOutputStream outContent;
	private Product product1;
	private Product product2;
	private Visitor visitor;

	@Before
	public void setUp() throws Exception {
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));

		this.product1 = new ConcreteProduct("Green River - Creedence Clearwater Revival - 1969",new ConcreteCategory("CD & Vinyl"),23.49);
		this.decoratedProduct1 = new DecoratedProduct(this.product1,10);
		
		this.product2 = new ConcreteProduct(null,null,0.00);
		this.decoratedProduct2 = new DecoratedProduct(this.product2,10);
		
		this.visitor = new MaxVisitor();
	}
	
	@Test
	public void testGetCategory() throws Exception {
		new ConcreteCategory("CD & Vinyl").equals(this.decoratedProduct1.getCategory());
	}
	
	@Test(expected = Exception.class)
	public void testGetCategoryException() throws Exception {
		new ConcreteCategory(null).equals(this.decoratedProduct2.getCategory());
	}
	
	@Test
	public void testGetDescription() throws Exception {
		assertEquals("Green River - Creedence Clearwater Revival - 1969", decoratedProduct1.getDescription());
	}
	
	@Test(expected = Exception.class)
	public void testGetDescriptionException() throws Exception {
		assertEquals(null,decoratedProduct2.getDescription());
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals("Base discount", decoratedProduct1.getDiscount().toString());
	}

	@Test
	public void testGetPrice() {
		assertEquals(21.141, decoratedProduct1.getPrice(), 0.1);
	}
	
	@Test
	public void testGetQuantity() throws Exception {
		assertEquals(1, decoratedProduct1.getQuantity());
	}
	
	@Test(expected = Exception.class)
	public void testGetQuantityException() throws Exception {
		assertEquals(0.00,decoratedProduct2.getQuantity(),0.1);
	}
	
	@Test
	public void testSetDiscount() {
		decoratedProduct1.setDiscount(new SummerDiscount(30));
		assertEquals(14.7987,decoratedProduct1.getPrice(),0.1);
	}
	
	@Test
	public void testSetPercentage() {
		decoratedProduct1.setPercentage(5);
		assertEquals(22.315, decoratedProduct1.getPrice(), 0.1);
	}
	
	@Test
	public void testSetQuantity() throws Exception {
		decoratedProduct1.setQuantity(2);
		assertEquals(2, decoratedProduct1.getQuantity(), 0.1);
	}
	
	@Test
	public void testAccept() throws Exception {
		this.decoratedProduct1.accept(this.visitor);
	}

	@Test
	public void testPrint() {
		decoratedProduct1.printItem();
		assertEquals("Description: Green River - Creedence Clearwater Revival - 1969 | "
				+ "Category: CD & Vinyl | Price: 23.49 | Quantity: 1 | Discount: 10% | Discounted price: "
				+ "21.14", outContent.toString());
	}
	
	@Test
	public void testToString() {
		assertEquals("Description: Green River - Creedence Clearwater Revival - 1969 | "
				+ "Category: CD & Vinyl | Price: 23.49 | Quantity: 1 | Discount: 10% | Discounted price: "
				+ "21.14", decoratedProduct1.toString());
	}
}
