package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Invoice.ShopTaxCalculator;
import util.Invoice.TaxCalculator;

public class ShopTaxCalculatorTest {
TaxCalculator taxCalculator;
	@Before
	public void setUp() throws Exception {
		taxCalculator = new ShopTaxCalculator();
	}

	@Test
	public void TaxCalculatorTest() {
		assertEquals(22,taxCalculator.taxCalculate(100, 22),0.1);
	}

	@Test
	public void TaxableTest(){
		assertEquals(78,taxCalculator.taxable(100, 22),0.1);
	}
}
