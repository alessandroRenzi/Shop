package database;

import category.Category;
import item.Item;

public class Stock {
	private static Stock instance = null;

	private Categories categories;
	private Items items;

	private Stock() {
		categories = new Categories();
		items = new Items();
	}

	public static Stock getInstance() {
		if(instance == null) {
			instance = new Stock();
		}
		return instance;
	}

	public Categories getCategories() {
		return categories;
	}

	public Items getItems() {
		return items;
	}

	public void addCategory(Category category) {
		categories.addToListCategories(category);
	}

	public void addItem(Item item) {
		items.addToListItems(item);
	}

	public void removeCategory(Category category) {
		categories.removeFromListCategories(category);
	}

	public void removeItem(Item item) {
		items.removeFromListItems(item);
	}
}
