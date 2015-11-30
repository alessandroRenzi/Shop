package item;

import report.Visitor;

public class ConcreteProduct extends Product {
	private String description;
	private double price;

	public ConcreteProduct(String description, double price) {
		this.description = description;
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
		return price;
	}

	@Override
	public void print() {
		printDescription();
		printPrice();
	}
	
	public void printDescription() {
		System.out.print(getDescription());
	}
	
	public void printPrice() {
		System.out.print(" - price: " + getPrice());
	}
}
