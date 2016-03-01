package gui.items;

import database.Items;
import database.Stock;
import item.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty description;
	private Stock stock = Stock.getInstance();

	public ItemsModelClass() {

	}

	public ItemsModelClass(Item item) {
		this.description = new SimpleStringProperty(item.getDescription());
	}

	public Items getItems() {
		return stock.getItems();
	}

	public void setItems(Items items) {
		Items stockItems = stock.getItems();
		stockItems = items;
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
