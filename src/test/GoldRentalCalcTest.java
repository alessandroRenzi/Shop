package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import item.Item;
import utilRentals.GoldRentalCalc;
import utilRentals.calcRental;

public class GoldRentalCalcTest {
	calcRental goldCalculate;
	LocalDate startDate;
	Item rent;
	
	@Before
	public void setUp() throws Exception {
		startDate = LocalDate.parse("2016-01-22");
		rent = new ConcreteProduct("Hurricane", "Dvd", 30);
		goldCalculate = new GoldRentalCalc();
	}

	
	@Test
	public void testRentalCalculation() {
		assertEquals(goldCalculate.calculate(startDate, rent), 6.8, 0.1);
	}

}
