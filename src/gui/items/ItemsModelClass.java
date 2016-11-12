package gui.items;

import item.Item;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty category;
	private StringProperty description;
	private DoubleProperty price;
	private IntegerProperty quantity;

	public ItemsModelClass() {
		super();
	}

	public ItemsModelClass(Item item) throws Exception {
		this.category = new SimpleStringProperty(item.getCategory().getCategory());  
		this.description = new SimpleStringProperty(item.getDescription());
		this.price = new SimpleDoubleProperty(item.getPrice());
		this.quantity = new SimpleIntegerProperty(item.getQuantity());
	}

	public String getCategory(){
		return this.category.get();
	}

	public String getDescription(){
		return this.description.get();
	}

	public Double getPrice(){
		return this.price.get();
	}

	public Integer getQuantity(){
		return this.quantity.get();
	}

	public void setCategory(String category){
		this.category.set(category);
	}

	public void setDescription(String description){
		this.description.set(description);
	}

	public void setPrice(Double price){
		this.price.set(price);
	}

	public void setQuantity(Integer quantity) {
		this.quantity.set(quantity);
	}

	public StringProperty getDescriptionProperty() {
		return description;
	}

	public StringProperty getCategoryProperty(){
		return this.category;
	}

	public DoubleProperty getPriceProperty(){
		return this.price;
	}

	public IntegerProperty getQuantityProperty(){
		return this.quantity;
	}

	public void setCategory(StringProperty category) {
		this.category = category;
	}

	public void setDescription(StringProperty description) {
		this.description = description;
	}

	public void setPrice(DoubleProperty price) {
		this.price = price;
	}

	public void setQuantity(IntegerProperty quantity) {
		this.quantity = quantity;
	}
}
