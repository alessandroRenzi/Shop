package gui.items;

import category.Category;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryModelClass {
	private StringProperty category;

	public CategoryModelClass() {

	}

	public CategoryModelClass(Category category) {
		this.category = new SimpleStringProperty(category.getCategory());
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
