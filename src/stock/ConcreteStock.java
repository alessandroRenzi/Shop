
package stock;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import category.Category;
import item.Item;

public class ConcreteStock extends AbstractStock {
	private static ConcreteStock instance;

	private List<Category> listCategories;
	private List<Item> listItems;

	private ConcreteStock() {
		this.listCategories = new LinkedList<Category>();
		this.listItems = new LinkedList<Item>();
	}

	public static ConcreteStock getInstance() {
		if(instance == null) {
			instance = new ConcreteStock();
		}
		return instance;
	}

	@Override
	public List<Category> getCategories() {
		return listCategories;
	}

	@Override
	public List<Item> getItems() {
		return listItems;
	}

	@Override
	public void addCategory(Category category) {
		this.listCategories.add(category);
	}

	@Override
	public void addItem(Item item) {
		this.listItems.add(item);
	}

	public Iterator<Item> getIterator() {
		return listItems.iterator();
	}

	@Override
	public void removeCategory(Category category) {
		this.listCategories.remove(category);
	}

	@Override
	public void removeItem(Item item) {
		this.listItems.remove(item);
	}
}
