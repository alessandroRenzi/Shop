package item;

import report.Visitor;

public abstract class Product implements Item {
	@Override
	public void add(Item item) throws Exception {
		throw new Exception("The method add(Item) is not applicable for the arguments.");
	}

	public abstract void accept(Visitor visitor);
	public abstract double getPrice();
	public abstract void print();
}
