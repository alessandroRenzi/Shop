package item;

import category.Category;
import discount.BaseDiscount;
import discount.Discount;
import report.Visitor;

public class ConcreteProduct extends Product {
	private String description;
	private Discount discount;
	private Category category;
	private double price;

	public ConcreteProduct(String description, Category category, double price) {
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
	public void printItem() {
		System.out.print(this.toString());
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	@Override 
	public String toString() {
		return "Description: " + getDescription() + " | Category: " + this.category.getCategory() + " | Price: " + getPrice(); 
	}

	public double calcPrice() {
		double discountedPrice = discount.doDiscount(price,discount.getPercentage());
		double rounding = Math.pow(10,2);
		return Math.round(discountedPrice*rounding)/rounding;
	}

	@Override
	public Category getCategory() {
		return this.category;
	}

}
