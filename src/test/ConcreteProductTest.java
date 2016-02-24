package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import discount.TotalDiscount;
import item.ConcreteProduct;

public class ConcreteProductTest {
	private ByteArrayOutputStream outContent;
	private ConcreteProduct product;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		product = new ConcreteProduct("The Wall - Pink Floyd - 1979", "CD e Vinili", 6.99);
	}

	@Test
	public void testGetDescription() {
		assertEquals("The Wall - Pink Floyd - 1979", product.getDescription());
	}

	@Test
	public void testSetDescription() {
		product.setDescription("The Dark Side of the Moon - Pink Floyd - 1973");
		assertEquals("The Dark Side of the Moon - Pink Floyd - 1973", product.getDescription());
	}

	@Test
	public void testSetCategory() {
		product.setCategory("Musica digitale");
		assertEquals("Musica digitale", product.getCategory());
	}

	@Test
	public void testSetPrice() {
		product.setPrice(5.99);
		assertEquals(5.99,product.getPrice(),0.1);
	}

	@Test
	public void testGetPrice() {
		assertEquals(6.99,product.getPrice(),0.1);
	}

	@Test
	public void testPrint() {
		product.print();
		assertEquals("The Wall - Pink Floyd - 1979 - CD e Vinili - price: 6.99", outContent.toString());
	}

	@Test
	public void testSetDiscount() {
		product.setDiscount(new TotalDiscount());
		assertEquals(0.00,product.getPrice(),0.1);
	}
}
