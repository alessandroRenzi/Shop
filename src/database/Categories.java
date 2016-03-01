package database;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import category.Category;

public class Categories {
	private List<Category> listCategories;

	public Categories() {
		listCategories = new LinkedList<Category>();
	}

	public List<Category> getListCategories() {
		return listCategories;
	}

	public void addToListCategories(Category category) {
		this.listCategories.add(category);
	}

	public void removeFromListCategories(Category category) {
		this.listCategories.remove(category);
	}

	public Iterator<Category> getIterator() {
		return listCategories.iterator();
	}
}
