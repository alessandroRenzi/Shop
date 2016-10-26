package test.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.TotalDiscount;

public class TotalDiscountTest {
	private TotalDiscount discount;

	@Before
	public void setUp() {
		discount = new TotalDiscount();
	}

	@Test
	public void testGetPercentage() {
		assertEquals(100,discount.getPercentage(),0.1);
	}

	@Test
	public void testCalcDiscount() {
		assertEquals(0,discount.calcDiscount(26.00),0.1);
	}

	@Test
	public void testDiscountDescription() {
		assertEquals("Total discount",discount.discountDescription());
	}
	

	@Test
	public void testToString() {
		assertEquals("Total discount",discount.toString());
	}
}
