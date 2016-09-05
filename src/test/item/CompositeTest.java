package test.item;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import discount.ChristmasDiscount;
import item.*;

public class CompositeTest {
	private ByteArrayOutputStream outContent;
	private Composite composite;
	private ConcreteProduct concreteProduct;

	@Before
	public  void start() throws Exception{
		this.composite = new Composite("Complete Audioslave");
		this.concreteProduct = new ConcreteProduct("Audioslave - Audioslave - 2002",  new ConcreteCategory("CD e Vinili"), 5.74);

		this.composite.add(new ConcreteProduct("Out of Exile - Audioslave - 2005",  new ConcreteCategory("CD e Vinili"), 9.89));
		this.composite.add(new ConcreteProduct("Revelations - Audioslave - 2006",  new ConcreteCategory("CD e Vinili"), 10.89));
		this.composite.add(concreteProduct);

		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
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
	public void testSetDescription() {
		this.composite.setDescription("Audioslave discography");
		assertEquals("Audioslave discography",composite.getDescription());
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
	public void testPrintItem() {
		this.composite.printItem();
		assertEquals("Description: Complete Audioslave | Content:\n" 
				+ "Description: Out of Exile - Audioslave - 2005 | Category: CD e Vinili | Price: 9.89 | Quantity: 1" + "\n" 
				+ "Description: Revelations - Audioslave - 2006 | Category: CD e Vinili | Price: 10.89 | Quantity: 1" + "\n"
				+ "Description: Audioslave - Audioslave - 2002 | Category: CD e Vinili | Price: 5.74 | Quantity: 1" + "\n"
				,outContent.toString());
	}

	@Test
	public void testRemove() throws Exception {
		this.composite.remove(concreteProduct);
		assertEquals(2, composite.getMyItems().size(), 0.1);
	}

	@Test
	public void testSetDiscount() {
		this.composite.setDiscount(new ChristmasDiscount(20));
		assertEquals(21.216,composite.getPrice(),0.1);
	}
}
