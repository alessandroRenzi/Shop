package test.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Item;

public class ItemTest {
	private Item item1;
	private Item item2;
	
	@Before
	public void setUp() {
		item1 = new ConcreteProduct("Fear of the Dark - Iron Maiden - 1992",  new ConcreteCategory("CD e Vinili"), 11.49);
		item2 = new ConcreteProduct("A Matter of Life and Death - Iron Maiden - 2006", new ConcreteCategory("CD e Vinili"), 7.99);
	}
	
	@Test
	public void testCompareToFirstEqualToSecond() {
		assertEquals(0, item1.compareTo(item1));
	}
	
	@Test
	public void testCompareToFirstGreaterThanSecod() {
		assertEquals(1, item1.compareTo(item2));
	}
	
	@Test
	public void testCompareToSecondGreaterThanFirst() {
		assertEquals(-1, item2.compareTo(item1));
	}
}
