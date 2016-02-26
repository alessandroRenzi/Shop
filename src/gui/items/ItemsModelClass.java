package gui.items;

import database.Items;
import item.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty category;
	private Items items;

	public ItemsModelClass() {

	}

	public ItemsModelClass(Item item) {
		this.category = new SimpleStringProperty(item.getCategory());
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public String getCategory() {
		return category.get();
	}

	public void setCategory(String category) {
		this.category.set(category);
	}

	public StringProperty getCategoryProperty() {
		return category;
	}

	public void setCategoryProperty(StringProperty category) {
		this.category = category;
	}
}
