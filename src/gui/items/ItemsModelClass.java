package gui.items;

import item.Item;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemsModelClass {
	private StringProperty description,category;
	private DoubleProperty price;

	public ItemsModelClass() {
		super();
	}

	public ItemsModelClass(Item item) {
		this.description = new SimpleStringProperty(item.getDescription());
		this.price = new SimpleDoubleProperty(item.getPrice());
		this.category = new SimpleStringProperty(item.getCategory().getCategory());  
	}
	
	public String getCategory(){
		return this.category.get();
	}
	
	public StringProperty getCategoryProperty(){
		return this.category;
	}

	public String getDescription(){
		return this.description.get();
	}
	
	public Double getPrice(){
		return this.price.get();
	}

	public void setDescription(String description){
		this.description.set(description);
	}
    
	public void setPrice(Double price){
		this.price.set(price);
	}
	
	public StringProperty getDescriptionProperty() {
		return description;
	}
	
	public DoubleProperty getPriceProperty(){
		return this.price;
	}
	
	public void setDescriptionProperty(StringProperty description) {
		this.description = description;
	}
	
	public void setPriceProperty(DoubleProperty price){
		this.price = price;
	}
}
