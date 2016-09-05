package test.util.rentals;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Item;
import util.rentals.CalcRental;
import util.rentals.FullRentalCalc;

public class FullRentalCalcTest {
	CalcRental calculation;
	Item rent;
	LocalDate dateStart;
	LocalDate dateFinish;

	@Before
	public void setUp() throws Exception {
		rent = new ConcreteProduct("Hurricane",  new ConcreteCategory("DVD"), 30);
		dateStart = LocalDate.parse("2016-01-22");
		dateFinish = LocalDate.parse("2016-02-25");
		calculation = new FullRentalCalc(dateFinish);
	}

	@Test
	public void testDaysCalculation(){
		assertEquals(calculation.daysCalc(dateStart), 34);
	}

	@Test
	public void testCalculationRentalPrice() {
		assertEquals(calculation.calculate(dateStart,rent), 10.2 ,0.1 );
	}

}
