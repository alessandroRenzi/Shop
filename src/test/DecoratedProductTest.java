package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import item.DecoratedProduct;
import item.Product;

public class DecoratedProductTest {
	private DecoratedProduct decoratedProduct;
	private ByteArrayOutputStream outContent;
	private Product product;
	
	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		product = new ConcreteProduct("Green River - Creedence Clearwater Revival - 1969", 23.49);
		decoratedProduct = new DecoratedProduct(product, 10);
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(21.141, decoratedProduct.getPrice(), 0.1);
	}
	
	@Test
	public void testPrint() {
		decoratedProduct.print();
		assertEquals("Green River - Creedence Clearwater Revival - 1969 - price: 23.49 - 10% = 21.141", outContent.toString());
	}

}
