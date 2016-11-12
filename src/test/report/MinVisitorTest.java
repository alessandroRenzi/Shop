package test.report;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import item.ConcreteProduct;
import report.MinVisitor;

public class MinVisitorTest {
	private MinVisitor min;
	private ConcreteProduct product1;
	private ConcreteProduct product2;

	@Before
	public void setUp() throws Exception {
		min = new MinVisitor();

		product1 = new ConcreteProduct("Highway 61 Revisited - Bob Dylan - 1965",  new ConcreteCategory("CD e Vinili"), 21.50);
		product2 = new ConcreteProduct("Desire - Bob Dylan - 1976",  new ConcreteCategory("CD e Vinili"), 20.00);
	}

	@Test
	public void testMin() {
		assertEquals(min.evaluate(product1, product2), false);
	}
	
	@Test
	public void testMinReverseComparison() {
		assertEquals(min.evaluate(product2, product1), true);
	}
}
