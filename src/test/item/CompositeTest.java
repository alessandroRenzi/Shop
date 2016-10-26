package test.item;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import discount.ChristmasDiscount;
import item.*;
import report.MaxVisitor;
import report.Visitor;

public class CompositeTest {
	private Composite composite;
	private ConcreteProduct concreteProduct1;
	private ConcreteProduct concreteProduct2;
	private ConcreteProduct concreteProduct3;
	private ByteArrayOutputStream outContent;
	private Visitor visitor;
	
	@Before
	public  void start() throws Exception{
		this.concreteProduct1 = new ConcreteProduct("Audioslave - Audioslave - 2002",  new ConcreteCategory("CD e Vinili"), 5.74);
		this.concreteProduct2 = new ConcreteProduct("Out of Exile - Audioslave - 2005",  new ConcreteCategory("CD e Vinili"), 9.89);
		this.concreteProduct3 = new ConcreteProduct("Revelations - Audioslave - 2006",  new ConcreteCategory("CD e Vinili"), 10.89);

		this.composite = new Composite("Complete Audioslave");
		this.composite.addItem(this.concreteProduct1);
		this.composite.addItem(this.concreteProduct2);
		this.composite.addItem(this.concreteProduct3);

		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		this.visitor = new MaxVisitor();
	}

	@Test
	public void testGetCategory() {
		assertEquals("Composite", composite.getCategory().getCategory());
	}

	@Test
	public void testGetDescription() {
		assertEquals("Complete Audioslave",composite.getDescription());
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals("Base discount",composite.getDiscount().toString());
	}

	@Test
	public void testGetPrice() {
		assertEquals(26.52,composite.getPrice(),0.1);
	}
	
	@Test
	public void testSetDescription() {
		this.composite.setDescription("Audioslave discography");
		assertEquals("Audioslave discography",composite.getDescription());
	}
	
	@Test
	public void testSetDiscount() {
		this.composite.setDiscount(new ChristmasDiscount(20));
		assertEquals(21.216,composite.getPrice(),0.1);
	}
	
	@Test
	public void testSetQuantity() {
		this.composite.setQuantity(2);
		assertEquals(2,composite.getQuantity());
	}
	
	@Test
	public void testAccept() {
		this.composite.accept(visitor);
	}

	@Test
	public void testPrintItem() {
		this.composite.printItem();
		assertEquals("Description: Complete Audioslave | Content:\n" 
				+ "Description: Audioslave - Audioslave - 2002 | Category: CD e Vinili | Price: 5.74 | Quantity: 1" + "\n" 
				+ "Description: Out of Exile - Audioslave - 2005 | Category: CD e Vinili | Price: 9.89 | Quantity: 1" + "\n"
				+ "Description: Revelations - Audioslave - 2006 | Category: CD e Vinili | Price: 10.89 | Quantity: 1" + "\n"
				,outContent.toString());
	}

	@Test
	public void testRemove() throws Exception {
		this.composite.removeItem(this.concreteProduct1);
		assertEquals(2, composite.getMyItems().size(), 0.1);
	}
	
	@Test(expected = Exception.class)
	public void testRemoveException() throws Exception {
		this.composite.removeItem(this.concreteProduct1);
		this.composite.removeItem(this.concreteProduct2);
		this.composite.removeItem(this.concreteProduct3);
		this.composite.removeItem(this.concreteProduct1);
	}
}
