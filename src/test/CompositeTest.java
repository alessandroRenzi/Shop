package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import item.*;

public class CompositeTest {
	private ByteArrayOutputStream outContent;
	private Composite composite;
	private ConcreteProduct concreteProduct;

	@Before
	public  void start() throws Exception{
		composite = new Composite("Complete Audioslave");
		concreteProduct = new ConcreteProduct("Audioslave - Audioslave - 2002", "CD e Vinili", 5.74);

		composite.add(new ConcreteProduct("Out of Exile - Audioslave - 2005", "CD e Vinili", 9.89));
		composite.add(new ConcreteProduct("Revelations - Audioslave - 2006", "CD e Vinili", 10.89));
		composite.add(concreteProduct);

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testGetDescription() {
		assertEquals("Complete Audioslave",composite.getDescription());
	}

	@Test
	public void testSetDescription() {
		composite.setDescription("Audioslave discography");
		assertEquals("Audioslave discography",composite.getDescription());
	}

	@Test
	public void testGetPrice() {
		assertEvaluatesTo(composite, 26.52);
	}

	private void assertEvaluatesTo(Item item, double expected) {
		assertEquals(expected,item.getPrice(),0.1);
	}

	@Test
	public void testPrint() {
		composite.print();
		assertEquals("Complete Audioslave - price: 26.520000000000003",outContent.toString());
	}
}
