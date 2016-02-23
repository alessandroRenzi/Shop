package gui.view;

import item.Item;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConcreteItemProperty implements ItemProperty {
	private StringProperty description;
	private StringProperty category;
	private DoubleProperty price;

	public ConcreteItemProperty(Item cP) {
		this.category = new SimpleStringProperty(cP.getCategory());
		this.price = new SimpleDoubleProperty(cP.getPrice());
	}

	public StringProperty getDescription() {
		return description;
	}

	public void setDescription(StringProperty description) {
		this.description = description;
	}

	public StringProperty getCategory() {
		return category;
	}

	public void setCategory(StringProperty category) {
		this.category = category;
	}

	public DoubleProperty getPrice() {
		return price;
	}

	public void setPrice(DoubleProperty price) {
		this.price = price;
	}
}
