package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Product;
import report.MaxVisitor;

public class MaxVisitorTest {
	private Product product1;
	private Product product2;
	private MaxVisitor max;

	@Before
	public void setUp() {
		product1 = new Product("Nevermind (20th Anniversary) - Nirvana - 2011", 5.99);
		product2 = new Product("Ten - Pearl Jam - 1992", 7.99);

		max = new MaxVisitor();
	}

	@Test
	public void testMax() {
		assertEquals(max.evaluate(product1, product2),false);
	}
}

