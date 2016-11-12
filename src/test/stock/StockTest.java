package test.stock;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import category.Category;
import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Item;
import stock.ConcreteStock;

public class StockTest {
	private List<Category> listCategories;
	private List<Item> listItems;
	private ByteArrayOutputStream outContent;
	private ConcreteStock stock = ConcreteStock.getInstance();
	
	private void populateListCategories(List<Category> listCategories) {
		listCategories.add(new ConcreteCategory("Musical Instruments"));
		listCategories.add(new ConcreteCategory("CDs & Vinyl"));
		listCategories.add(new ConcreteCategory("Cell Phones & Accessories"));
		listCategories.add(new ConcreteCategory("Books"));
	}
	
	private void populateListItems(List<Item> listItems) throws Exception {
		listItems.add(new ConcreteProduct("Fender American Elite Stratocaster HSS Shawbucker",new ConcreteCategory("Musical Instruments"),1929.00));
		listItems.add(new ConcreteProduct("Nevermind - Nirvana - Audio CD",new ConcreteCategory("CDs & Vinyl"),12.06));
		listItems.add(new ConcreteProduct("Paul Reed Smith SE 30th Anniversary Custom 24",new ConcreteCategory("Musical Instruments"),1643.75));
		listItems.add(new ConcreteProduct("Samsung Galaxy S7 Edge Factory Unlocked Phone 32 GB",new ConcreteCategory("Cell Phones & Accessories"),677.80));
		listItems.add(new ConcreteProduct("Ten - Pearl Jam - Vinyl",new ConcreteCategory("CDs & Vinyl"),24.00));
		listItems.add(new ConcreteProduct("The Old Man and The Sea by Ernest Hemingway",new ConcreteCategory("Books"),8.30));
	}
	
	@Before
	public void setUp() throws Exception {
		this.listItems = new LinkedList<Item>();
		this.populateListItems(this.listItems);
		
		this.listCategories = new LinkedList<Category>();
		this.populateListCategories(this.listCategories);
		
		this.outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(this.outContent));
	}

	@Test
	public void testGetCategories() {
		for(int i = 0; i < this.listCategories.size(); i++) {
			this.listCategories.get(i).equals(this.stock.getCategories().get(i));
		}
	}
	
	@Test
	public void testRemoveCategory() {
		int lengthBefore = this.stock.getCategories().size();
		this.stock.removeCategory(this.stock.getCategories().get(0));
		int lengthAfter = this.stock.getCategories().size();
		assertEquals(lengthBefore, lengthAfter+1);
	}
	
	@Test
	public void testRemoveItem() {
		int lengthBefore = this.stock.getItems().size();
		this.stock.removeItem(this.stock.getItems().get(0));
		int lengthAfter = this.stock.getItems().size();
		assertEquals(lengthBefore, lengthAfter+1);
	}
}