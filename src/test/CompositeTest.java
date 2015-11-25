package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import discount.*;
import item.*;

public class CompositeTest {
	Composite pack01 = new Composite("Ciao!");
	Product Scanner = new Product("Scanner", 130);

	@Before
	public  void start() throws Exception{
		pack01.add(new Product("Usb Cable", 10));
		pack01.add(new Product("TV", 150));
		pack01.add(Scanner);
	}

	@Test
	public void testGetPrice() {
		assertEvaluatesTo(pack01, 290);
	}

	@Test
	public void testStrategy() {
		pack01.setDiscount(new GratisDiscount());
		assertEvaluatesTo(pack01, 0);
	}

	private void assertEvaluatesTo(Item item, double expected) {
		assertEquals(expected, item.getPrice(), 0.1);
	}

}
