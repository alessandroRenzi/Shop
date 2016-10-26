package test.item;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import discount.TotalDiscount;
import item.ConcreteProduct;
import report.MaxVisitor;
import report.Visitor;

public class ConcreteProductTest {
	private ByteArrayOutputStream outContent;
	private ConcreteProduct product;
	private Visitor visitor;

	@Before
	public void setUp() throws Exception {
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		this.product = new ConcreteProduct("The Wall - Pink Floyd - 1979",new ConcreteCategory("CD e Vinili"),6.99);
		this.visitor = new MaxVisitor();
	}

	@Test
	public void testGetCategory() {
		assertEquals("CD e Vinili",this.product.getCategory().getCategory());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("The Wall - Pink Floyd - 1979",this.product.getDescription());
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals("Base discount",this.product.getDiscount().toString());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(6.99,this.product.getPrice(),0.1);
	}

	@Test
	public void testSetCategory() {
		this.product.setCategory(new ConcreteCategory("Elettrodomestici"));
		assertEquals("Elettrodomestici",this.product.getCategory().getCategory());
	}

	@Test
	public void testSetDescription() {
		this.product.setDescription("The Dark Side of the Moon - Pink Floyd - 1973");
		assertEquals("The Dark Side of the Moon - Pink Floyd - 1973",this.product.getDescription());
	}
	
	@Test
	public void testSetDiscount() {
		this.product.setDiscount(new TotalDiscount());
		assertEquals(0.00,this.product.getPrice(),0.1);
	}
	
	@Test
	public void testSetQuantity() {
		this.product.setQuantity(2);
		assertEquals(2,this.product.getQuantity());
	}

	@Test
	public void testSetPrice() {
		this.product.setPrice(5.99);
		assertEquals(5.99,this.product.getPrice(),0.1);
	}

	@Test
	public void testAccept() throws Exception {
		this.product.accept(this.visitor);
	}
	
	@Test
	public void testPrint() {
		this.product.printItem();
		assertEquals("Description: The Wall - Pink Floyd - 1979 | Category: CD e Vinili | Price: 6.99 | Quantity: 1",
				this.outContent.toString());
	}
}
