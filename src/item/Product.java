package item;

import category.Category;
import discount.Discount;
import report.Visitor;

public abstract class Product implements Item {
	@Override
	public void add(Item item) throws Exception {
		throw new Exception("The method add(Item) is not applicable for this argument.");
	}

	@Override
	public void remove(Item item) throws Exception {
		throw new Exception("The method remove(Item) is not applicable for this argument.");
	}

	public abstract void accept(Visitor visitor);
	public abstract Category getCategory();
	public abstract String getDescription();
	public abstract double getPrice();
	public abstract void printItem();
	public abstract void setDiscount(Discount discount);
}
