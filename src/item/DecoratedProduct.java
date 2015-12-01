package item;

import report.Visitor;

public class DecoratedProduct extends AbstractProduct {
	private int percentage;
	
	public DecoratedProduct(Product product, int percentage) {
		super(product);
		this.percentage = percentage;
	}
	
	@Override
	public double getPrice() {
		return getDecoratedPrice();
	}

	@Override
	public void print() {
		super.print();
		this.printDecoratedLeaf();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitDecoratedProduct(this);
	}
	
	public double getDecoratedPrice() {
		return (getProduct().getPrice()*(100-this.percentage))/100;
	}
	
	public void printDecoratedLeaf() {
		System.out.print(" - " + this.percentage + "% = " + getPrice());
	}
}
