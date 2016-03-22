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
		this.category = new ConcreteCategory("CDs and vinyls");
		this.other = new ConcreteCategory("Electronics");
	}

	@Test
	public void testGetCategory() {
		assertEquals("CDs and vinyls",category.getCategory());
	}

	@Test
	public void testSetCategory() {
		category.setCategory("Electronics");
		assertEquals("Electronics",category.getCategory());
	}

	@Test 
	public void testEqualsFalse(){
		assertFalse(category.equals(other));
	}

	@Test 
	public void testEqualsTrue(){
		assertTrue(category.equals(category));
	}
}
