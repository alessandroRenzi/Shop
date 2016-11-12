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
	private Discount discount = new BaseDiscount();
	private double price;
	private int quantity;
	private Stock stock = ConcreteStock.getInstance();

	public ConcreteProduct(String description, Category category, double price) throws Exception {
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = 1;
		this.stock.addItem(this);
	}

	@Override
	public Category getCategory() {
		return this.category;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Discount getDiscount() {
		return this.discount;
	}
	
	@Override
	public double getPrice() {
		return this.roundingPrice(this.discount,this.price);
	}
	
	public int getQuantity() {
		return this.quantity;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void accept(Visitor visitor) throws Exception {
		visitor.visitConcreteProduct(this);
	}

	@Override
	public void printItem() {
		System.out.print(this.toString());
	}

	@Override 
	public String toString() {
		return "Description: " + this.getDescription() + " | Category: " + this.category.getCategory() 
				+ " | Price: " + this.getPrice() + " | Quantity: " + this.getQuantity(); 
	}
}
