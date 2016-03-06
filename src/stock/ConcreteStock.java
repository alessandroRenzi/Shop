package stock;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import category.Category;
import item.Item;

public class ConcreteStock extends AbstractStock {
	private static ConcreteStock instance = null;

	private List<Category> listCategories;
	private List<Item> listItems;

	private ConcreteStock() {
		this.listCategories = new LinkedList<Category>();
		this.listItems = new LinkedList<Item>();
	}

	public static Stock getInstance() {
		if(instance == null) {
			instance = new ConcreteStock();
		}
		return instance;
	}

	public List<Category> getCategories() {
		return listCategories;
	}

	public List<Item> getItems() {
		return listItems;
	}

	public void addCategory(Category category) {
		this.listCategories.add(category);
	}

	public void addItem(Item item) {
		this.listItems.add(item);
	}

	public Iterator<Item> getIterator() {
		return listItems.iterator();
	}

	public void removeFromListCategories(Category category) {
		this.listCategories.remove(category);
	}

	public void removeFromListItems(Item item) {
		this.listItems.remove(item);
	}
}
