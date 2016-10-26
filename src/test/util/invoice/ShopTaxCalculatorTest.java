package test.util.invoice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.invoice.ShopTaxCalculator;
import util.invoice.TaxCalculator;

public class ShopTaxCalculatorTest {
	private TaxCalculator taxCalculator;

	@Before
	public void setUp() throws Exception {
		this.taxCalculator = new ShopTaxCalculator();
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
