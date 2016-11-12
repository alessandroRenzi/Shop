package test.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.ChristmasDiscount;

public class ChristmasDiscountTest {
	private ChristmasDiscount discount;

	@Before
	public void setUp() {
		discount = new ChristmasDiscount(10);
	}

	@Test
	public void testGetPercentage() {
		assertEquals(10.00,discount.getPercentage(),0.1);
	}

	@Test
	public void testCalcDiscount() {
		assertEquals(23.40,discount.calcDiscount(26.00),0.1);
	}

	@Test
	public void testDiscountDescription() {
		assertEquals("Christmas discount",discount.discountDescription());
	}
	
	@Test
	public void testToString() {
		assertEquals("Christmas discount",discount.toString());
	}
}
