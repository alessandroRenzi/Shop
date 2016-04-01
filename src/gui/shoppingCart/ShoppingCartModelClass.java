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

	public ShoppingCartModelClass(Item item, Cart cart ){
		this.category =new SimpleStringProperty(item.getCategory().getCategory());
		this.description = new SimpleStringProperty(item.getDescription());
		this.discount  = new SimpleStringProperty(item.getDiscount().toString());
		this.price = new SimpleDoubleProperty(item.getPrice()); 
		this.quantity = new SimpleIntegerProperty(cart.getQuantityItems());
	}

	public StringProperty getCategoryProperty() {
		return this.category;
	}

	public String getCategory(){
		return this.category.get();
	}

	public StringProperty getDescriptionProperty() {
		return this.description;
	}

	public String getDescription(){
		return this.description.get();
	}

	public StringProperty getDiscountProperty() {
		return discount;
	}

	public String getDiscount(){
		return this.discount.get();
	}

	public DoubleProperty getPriceProperty() {
		return price;
	}

	public Double getPrice(){
		return this.price.get();
	}

	public int getQuantity(){
		return this.quantity.get();
	}

	public IntegerProperty getQuantityProperty() {
		return quantity;
	}
}
