package gui.items;

import database.Items;
import item.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty description;
	private Items items;

	public ItemsModelClass() {

	}

	public ItemsModelClass(Item item) {
		this.description = new SimpleStringProperty(item.getDescription());
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
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
