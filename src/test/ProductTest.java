package test;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Product;

public class ProductTest {
	private Product product1;
	private Product product2;
	
	@Before 
	public void setUp() {
		product1 = new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 8.72);
		product2 = new ConcreteProduct("Vs. - Pearl Jam - 1993",  new ConcreteCategory("CD e Vinili"), 19.12);
	}
	
	@Test(expected = Exception.class)
	public void testAdd() throws Exception {
		product1.add(product2);
	}
	
	@Test(expected = Exception.class)
	public void testRemove() throws Exception {
		product1.remove(product2);
	}
}
