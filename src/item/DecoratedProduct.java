package item;

import discount.Discount;
import report.Visitor;
import stock.ConcreteStock;
import stock.Stock;

public class DecoratedProduct extends AbstractProduct {
	private int percentage;
	private Stock stock = ConcreteStock.getInstance();

	public DecoratedProduct(Product product, int percentage) throws Exception {
		super(product);
		this.percentage = percentage;
		this.stock.addItem(this);
	}
	
	public double getDecoratedPrice() {
		double rounding = Math.pow(10,2);
		double decoratedPrice = (getProduct().getPrice()*(100-this.percentage))/100;
		return Math.round(decoratedPrice*rounding)/rounding;
	}
	
	@Override
	public Discount getDiscount() {
		return super.getDiscount();
	}

	public int getPercentage() {
		return percentage;
	}
	
	@Override
	public double getPrice() {
		return getDecoratedPrice();
	}
	
	@Override
	public int getQuantity() throws Exception {
		return super.getQuantity();
	}
	
	@Override
	public void setDiscount(Discount discount) {
		super.setDiscount(discount);
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public void setQuantity(int quantity) {
		super.setQuantity(quantity);
	}

	@Override
	public void accept(Visitor visitor) throws Exception {
		visitor.visitDecoratedProduct(this);
	}
	
	public String decoratedProductToString() {
		return " | Discount: " + getPercentage() + "% | Discounted price: " + getPrice();	
	}

	public void printDecoratedProduct() {
		System.out.print(this.decoratedProductToString());
	}
	
	@Override
	public void printItem() {
		super.printItem();
		this.printDecoratedProduct();
	}

	@Override
	public String toString() {
		return super.toString() + this.decoratedProductToString();
	}
}
