package stock;

import java.util.Iterator;
import java.util.List;

import category.Category;
import category.ConcreteCategory;
import item.ConcreteProduct;
import item.Item;

public abstract class AbstractStock implements Stock {
	@Override
	public void initialize() {
		new ConcreteProduct("The Old Man and The Sea by Ernest Hemingway",  new ConcreteCategory("Books"), 8.30);
		new ConcreteProduct("Nevermind - Nirvana - Audio CD",  new ConcreteCategory("CDs & Vinyl"), 12.06);
		new ConcreteProduct("Ten - Pearl Jam - Vinyl",  new ConcreteCategory("CDs & Vinyl"), 24.00);
		new ConcreteProduct("Samsung Galaxy S7 Edge Factory Unlocked Phone 32 GB",  new ConcreteCategory("Cell Phones & Accessories"), 677.80);
	}

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
