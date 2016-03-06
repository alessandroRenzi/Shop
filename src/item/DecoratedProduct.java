package item;

import discount.Discount;
import report.Visitor;
import stock.ConcreteStock;
import stock.Stock;

public class DecoratedProduct extends AbstractProduct {
	private int percentage;
	private Stock stock = ConcreteStock.getInstance();

	public DecoratedProduct(Product product, int percentage) {
		super(product);
		this.percentage = percentage;
		this.stock.addItem(this);
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitDecoratedProduct(this);
	}

	@Override
	public double getPrice() {
		return getDecoratedPrice();
	}

	@Override
	public void printItem() {
		super.printItem();
		this.printDecoratedProduct();
	}

	@Override
	public void setDiscount(Discount discount) {
		super.setDiscount(discount);
	}

	public double getDecoratedPrice() {
		double rounding = Math.pow(10,2);
		double decoratedPrice = (getProduct().getPrice()*(100-this.percentage))/100;
		return Math.round(decoratedPrice*rounding)/rounding;
	}

	public void printDecoratedProduct() {
		System.out.print(this.decoratedProductToString());
	}

	@Override
	public String toString() {
		return super.toString() + this.decoratedProductToString();
	}

	public String decoratedProductToString() {
		return " | Discount: " + getPercentage() + "% | Discounted price: " + getPrice();	
	}
}
