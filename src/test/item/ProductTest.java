package test.item;

import org.junit.Before;
import org.junit.Test;

import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Product;

public class ProductTest {
	private Product product1;
	private Product product2;
	
	@Before 
	public void setUp() throws Exception {
		this.product1 = new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 8.72);
		this.product2 = new ConcreteProduct("Vs. - Pearl Jam - 1993",  new ConcreteCategory("CD e Vinili"), 19.12);
	}
	
	@Test
	public void testAdd() {
		try {
			this.product1.addItem(this.product2);
		} catch (Exception e) {
			new Exception("The method add(Item) is not applicable for this argument.");
		}
	}
	
	@Test
	public void testRemove() {
		try {
			this.product1.removeItem(this.product2);
		} catch (Exception e) {
			new Exception("The method remove(Item) is not applicable for this argument.");
		}
	}
}
