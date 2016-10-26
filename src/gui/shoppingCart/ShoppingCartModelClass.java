package gui.shoppingCart;

import cart.Cart;

import item.Item;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShoppingCartModelClass {
	private StringProperty category;
	private StringProperty description;
	private StringProperty discount;
	private DoubleProperty price;
	private IntegerProperty quantity; 

	public ShoppingCartModelClass(Item item, Cart cart ) throws Exception {
		this.category = new SimpleStringProperty(item.getCategory().getCategory());
		this.description = new SimpleStringProperty(item.getDescription());
		this.discount  = new SimpleStringProperty(item.getDiscount().toString());
		this.price = new SimpleDoubleProperty(item.getPrice()); 
		this.quantity = new SimpleIntegerProperty(item.getQuantity());
	}

	public String getCategory() {
		return this.category.get();
	}

	public String getDescription() {
		return this.description.get();
	}

	public String getDiscount() {
		return this.discount.get();
	}

	public Double getPrice() {
		return this.price.get();
	}

	public Integer getQuantity() {
		return this.quantity.get();
	}

	public void setCategory(String category){
		this.category.set(category);
	}

	public void setDescription(String description) {
		this.description.set(description);
	}
	
	public void setDiscount(String discount) {
		this.discount.set(discount);
	}

	public void setPrice(Double price){
		this.price.set(price);
	}

	public void setQuantity(Integer quantity) {
		this.quantity.set(quantity);
	}
	
	public StringProperty getCategoryProperty() {
		return this.category;
	}

	public StringProperty getDescriptionProperty() {
		return this.description;
	}

	public StringProperty getDiscountProperty() {
		return discount;
	}

	public DoubleProperty getPriceProperty() {
		return price;
	}

	public IntegerProperty getQuantityProperty() {
		return quantity;
	}

	public void setCategory(StringProperty category) {
		this.category = category;
	}

	public void setDescription(StringProperty description) {
		this.description = description;
	}

	public void setDiscount(StringProperty discount) {
		this.discount = discount;
	}

	public void setPrice(DoubleProperty price) {
		this.price = price;
	}

	public void setQuantity(IntegerProperty quantity) {
		this.quantity = quantity;
	}
}
