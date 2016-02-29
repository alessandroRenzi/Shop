package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import category.Category;
import category.ItemCategory;

public class CategoryTest {
	private Category category;
	
	@Before
	public void setUp(){
		this.category = new ItemCategory("CD");
	}
	@Test
	public void getCategoryTest() {
		assertEquals (this.category.getCategory(), "CD");
	}

}
