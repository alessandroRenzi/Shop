package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import category.Category;
import category.ConcreteCategory;

public class CategoryTest {
	private Category category;
	private Category other;
	@Before
	public void setUp(){
		this.category = new ConcreteCategory("CD");
		this.other = new ConcreteCategory("Telefonia");
	}
	@Test
	public void getCategoryTest() {
		assertEquals (this.category.getCategory(), "CD");
	}

	@Test 
	public void equalsTest(){
		assertFalse(this.category.equals(this.other));
	}
	
}
