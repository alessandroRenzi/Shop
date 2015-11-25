package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.Product;
import report.MinVisitor;

public class MinVisitorTest {
	private Product product1;
	private Product product2;
	private MinVisitor min;

	@Before
	public void setUp() {
		product1 = new Product("Nevermind (20th Anniversary) - Nirvana - 2011", 5.99);
		product2 = new Product("Ten - Pearl Jam - 1992", 7.99);

		min = new MinVisitor();
	}

	@Test
	public void testMin() {
		assertEquals(min.evaluate(product1, product2),true);
	}
}
