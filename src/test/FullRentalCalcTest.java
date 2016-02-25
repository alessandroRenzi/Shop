package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import item.Item;
import utilRentals.FullRentalCalc;
import utilRentals.calcRental;

public class FullRentalCalcTest {
	calcRental calculation;
	Item rent;
	LocalDate date;
	@Before
	public void setUp() throws Exception {
		calculation = new FullRentalCalc();
		rent = new ConcreteProduct("Hurricane", "Dvd", 30);
		date = LocalDate.parse("2016-01-22");
	}

	@Test
	public void testDaysCalculation(){
		assertEquals(calculation.daysCalc(date), 34);
	}
	@Test
	public void testCalculationRentalPrice() {
		assertEquals(calculation.calculate(date,rent), 10.2 ,0.1 );
	}

}
