package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import report.MinVisitor;

public class MinVisitorTest {
	private ConcreteProduct product1;
	private ConcreteProduct product2;
	private MinVisitor min;

	@Before
	public void setUp() {
		product1 = new ConcreteProduct("Nevermind (20th Anniversary) - Nirvana - 2011", 5.99);
		product2 = new ConcreteProduct("Ten - Pearl Jam - 1992", 7.99);

		min = new MinVisitor();
	}

	@Test
	public void testMin() {
		assertEquals(min.evaluate(product1, product2),true);
	}
}
