package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import item.*;

public class CompositeTest {
	Composite pack01 = new Composite("Ciao!");
	ConcreteProduct Scanner = new ConcreteProduct("Scanner",130);

	@Before
	public  void start() throws Exception{
		pack01.add(new ConcreteProduct("Usb Cable",10));
		pack01.add(new ConcreteProduct("TV",150));
		pack01.add(Scanner);
	}

	@Test
	public void testGetPrice() {
		assertEvaluatesTo(pack01,290);
	}

	private void assertEvaluatesTo(Item item, double expected) {
		assertEquals(expected,item.getPrice(),0.1);
	}
}
