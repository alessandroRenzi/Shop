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
		new ConcreteProduct("Nevermind - Nirvana - 1991",  new ConcreteCategory("CD e Vinili"), 19.12);
		new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 7.50);
		new ConcreteProduct("Samsung Galaxy Note 5 N920i",  new ConcreteCategory("Telefonia"), 690.00);
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
