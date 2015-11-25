package item;

import discount.*;
import report.Visitor;

public class Product implements Item {
	private String description;
	private double price;
	private Discount discount;

	public Product(String description, double price) {
		this.description = description;
		this.price = price;
		setDiscount(new BaseDiscount());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}	

	public Discount getDiscount() {
		return discount;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitProduct(this);
	}

	@Override
	public void add(Item item) throws Exception {
		throw new Exception("The method add(Item) is not applicable for the arguments.");
	}

	@Override
	public double getPrice() {
		return discount.discount(price);
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return getDescription() + " - price: " + getPrice();
	}
}
