package test.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.BaseDiscount;

public class BaseDiscountTest {
	private BaseDiscount discount;

	@Before
	public void setUp() {
		discount = new BaseDiscount();
	}

	@Test
	public void testGetPercentage() {
		assertEquals(0,discount.getPercentage(),0.1);
	}

	@Test
	public void testCalcDiscount() {
		assertEquals(26.00,discount.calcDiscount(26.00),0.1);
	}

	@Test
	public void testDiscountDescription() {
		assertEquals("Base discount",discount.discountDescription());
	}
	
	@Test
	public void testToString() {
		assertEquals("Base discount",discount.toString());
	}
}
