package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.GratisDiscount;
import discount.Discount;
import item.Product;

public class GratisDiscountTest {
	private Product product1;
	private Product product2;
	private Discount strategy;

	@Before
	public void setUp() {
		product1 = new Product("Nevermind (20th Anniversary) - Nirvana - 2011", 5.99);
		product2 = new Product("Ten - Pearl Jam - 1992", 7.99);

		strategy = new GratisDiscount();
	}

	@Test
	public void testGratisStrategy1() {
		product1.setDiscount(strategy);
		assertEquals(0.00,product1.getPrice(),0.1);
	}

	@Test
	public void testGratisStrategy2() {
		product2.setDiscount(strategy);
		assertEquals(0.00,product2.getPrice(),0.1);
	}
}
