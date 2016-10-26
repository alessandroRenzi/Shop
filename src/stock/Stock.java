package stock;

import java.util.List;

import category.Category;
import item.Item;

public interface Stock {
	void addCategory(Category category);
	void addItem(Item item);
	List<Category> getCategories();
	List<Item> getItems();
	void initialize() throws Exception;
	void print();
	void removeCategory(Category category);
	void removeItem(Item item);
}
