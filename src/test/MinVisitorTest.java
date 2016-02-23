package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import report.MinVisitor;

public class MinVisitorTest {
	private MinVisitor min;
	private ConcreteProduct product1;
	private ConcreteProduct product2;

	@Before
	public void setUp() {
		min = new MinVisitor();

		product1 = new ConcreteProduct("Highway 61 Revisited - Bob Dylan - 1965", "CD e Vinili", 21.50);
		product2 = new ConcreteProduct("Desire - Bob Dylan - 1976", "CD e Vinili", 20.00);
	}

	@Test
	public void testMin() {
		assertEquals(min.evaluate(product1, product2), false);
	}
}
