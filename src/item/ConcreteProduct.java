package item;

import category.Category;
import discount.BaseDiscount;
import discount.Discount;
import report.Visitor;
import stock.ConcreteStock;
import stock.Stock;

public class ConcreteProduct extends Product {
	private Category category;
	private String description;
	private Discount discount;
	private double price;
	private Stock stock = ConcreteStock.getInstance();

	public ConcreteProduct(String description, Category category, double price) {
		this.category = category;
		this.description = description;
		this.discount = new BaseDiscount();
		this.price = price;
		this.stock.addItem(this);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Discount getDiscount() {
		return discount;
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
}
