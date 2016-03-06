package gui.items;

import item.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty description;

	public ItemsModelClass() {

	}

	public ItemsModelClass(Item item) {
		this.description = new SimpleStringProperty(item.getDescription());
	}

	public String getDescription(){
		return this.description.get();
	}

	public void setDescription(String description){
		this.description.set(description);
	}

	public StringProperty getDescriptionProperty() {
		return description;
	}

	public void setDescriptionProperty(StringProperty description) {
		this.description = description;
	}
}
