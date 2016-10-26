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
	LocalDate dateFinish;
	LocalDate dateStart;
	Item rent;

	@Before
	public void setUp() throws Exception {
		this.dateFinish = LocalDate.parse("2016-02-25");
		this.dateStart = LocalDate.parse("2016-01-22");
		
		this.calculation = new FullRentalCalc(dateFinish);
		this.rent = new ConcreteProduct("Hurricane",new ConcreteCategory("DVD"),30);
	}
	
	@Test
	public void testCalculationRentalPrice() {
		assertEquals(this.calculation.calculate(this.dateStart,this.rent),10.2,0.1);
	}

	@Test
	public void testDaysCalculation(){
		assertEquals(this.calculation.daysCalc(this.dateStart),34);
	}

	@Test
	public void testSetDate() {
		LocalDate newDate = LocalDate.parse("2016-10-25");
		this.calculation.setDate(newDate);
		assertEquals(this.calculation.daysCalc(this.dateStart),277);
	}
}
