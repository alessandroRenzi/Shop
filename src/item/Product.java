package item;

import category.Category;
import discount.Discount;
import report.Visitor;

public abstract class Product implements Item {
	@Override
	public void addItem(Item item) throws Exception {
		throw new Exception("The method add(Item) is not applicable for this argument.");
	}

	@Override
	public void removeItem(Item item) throws Exception {
		throw new Exception("The method remove(Item) is not applicable for this argument.");
	}

	public abstract void accept(Visitor visitor) throws Exception;
	public abstract Category getCategory() throws Exception;
	public abstract String getDescription() throws Exception;
	public abstract Discount getDiscount();
	public abstract double getPrice();
	public abstract void printItem();
	public abstract void setDiscount(Discount discount);
}
