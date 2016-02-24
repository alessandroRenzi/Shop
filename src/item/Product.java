package item;

import discount.Discount;
import report.Visitor;

public abstract class Product implements Item {
	public abstract void accept(Visitor visitor);
	
	@Override
	public void add(Item item) throws Exception {
		throw new Exception("The method add(Item) is not applicable for the arguments.");
	}
	
	public abstract double getPrice();
	public abstract void print();
	public abstract void setDiscount(Discount discount);
}
