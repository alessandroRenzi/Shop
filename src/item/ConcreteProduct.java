package item;

import discount.BaseDiscount;
import discount.Discount;
import report.Visitor;

public class ConcreteProduct extends Product {
	private String description;
	private Discount discount;
	private String category;
	private double price;

	public ConcreteProduct(String description, String category, double price) {
		this.description = description;
		this.discount = new BaseDiscount();
		this.category = category;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitConcreteProduct(this);
	}

	@Override
	public double getPrice() {
		return calcPrice();
	}

	@Override
	public void print() {
		printDescription();
		printCategory();
		printPrice();
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public double calcPrice() {
		double discountedPrice = discount.doDiscount(price,discount.getPercentage());
		double rounding = Math.pow(10,2);
		return Math.round(discountedPrice*rounding)/rounding;
	}

	public void printDescription() {
		System.out.print(getDescription());
	}

	public void printCategory() {
		System.out.print(" - " + getCategory());
	}

	public void printPrice() {
		System.out.print(" - price: " + getPrice());
	}
}
