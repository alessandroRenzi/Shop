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
		this.printDecoratedProduct();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitDecoratedProduct(this);
	}

	public double getDecoratedPrice() {
		double rounding = Math.pow(10,2);
		double decoratedPrice = (getProduct().getPrice()*(100-this.percentage))/100;
		return Math.round(decoratedPrice*rounding)/rounding;
	}

	public void printDecoratedProduct() {
		System.out.print(" - " + this.percentage + "% = " + getPrice());
	}
}
