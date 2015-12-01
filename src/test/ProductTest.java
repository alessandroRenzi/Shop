package test;

import org.junit.Before;
import org.junit.Test;

import item.ConcreteProduct;
import item.Product;

public class ProductTest {
	private Product product1;
	private Product product2;
	
	@Before 
	public void setUp() {
		product1 = new ConcreteProduct("Ten - Pearl Jam - 1991", 8.72);
		product2 = new ConcreteProduct("Vs. - Pearl Jam - 1993", 19.12);
	}
	
	@Test(expected= Exception.class)
	public void test() throws Exception {
		product1.add(product2);
	}
}
