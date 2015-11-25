package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.TwentyPercDiscount;

public class TwentyPercDiscountTest {

	private TwentyPercDiscount twenty;
	
	@Before
	public void setUp(){
		setTwenty(new TwentyPercDiscount());
	}
	
	@Test
	public void testForPositive() {
		assertEquals(8.0, twenty.discount(10),0.1);
	}
	
	@Test
	public void testForZero(){
		assertEquals(0.0, twenty.discount(0),0.1);
	}
	
	public TwentyPercDiscount getTwenty() {
		return twenty;
	}

	public void setTwenty(TwentyPercDiscount twenty) {
		this.twenty = twenty;
	}

}
