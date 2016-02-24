package item;

import discount.Discount;
import report.Visitor;

public abstract class AbstractProduct extends Product {
	private Product product;

	public AbstractProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public void print() {
		if(this.product != null) {
			this.product.print();
		}
	}

	@Override
	public void setDiscount(Discount discount) {
		if(this.product != null) {
			this.product.setDiscount(discount);
		}
	}

	public abstract void accept(Visitor visitor);
	public abstract double getPrice();	
}
