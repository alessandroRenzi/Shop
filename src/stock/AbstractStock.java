package stock;

import java.util.Iterator;
import java.util.List;

import category.Category;
import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Item;

public abstract class AbstractStock implements Stock {
	
	public void initialize() throws Exception {
		new ConcreteProduct("Fender American Elite Stratocaster HSS Shawbucker", new ConcreteCategory("Musical Instruments"), 1929.00);
		new ConcreteProduct("Nevermind - Nirvana - Audio CD",  new ConcreteCategory("CDs & Vinyl"), 12.06);
		new ConcreteProduct("Paul Reed Smith SE 30th Anniversary Custom 24", new ConcreteCategory("Musical Instruments"), 1643.75);
		new ConcreteProduct("Samsung Galaxy S7 Edge Factory Unlocked Phone 32 GB", new ConcreteCategory("Cell Phones & Accessories"), 677.80);
		new ConcreteProduct("Ten - Pearl Jam - Vinyl", new ConcreteCategory("CDs & Vinyl"), 24.00);
		new ConcreteProduct("The Old Man and The Sea by Ernest Hemingway", new ConcreteCategory("Books"), 8.30);
	}

	@Override
	public void print() {
		Iterator<Item> iterator = getIterator();

		while(iterator.hasNext()) {
			Item current = iterator.next();
			System.out.println(current.toString());
		}
	}

	public abstract List<Category> getCategories();
	public abstract List<Item> getItems();
	abstract Iterator<Item> getIterator();
}
