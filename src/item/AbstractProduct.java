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
	public void printItem() {
		if(this.product != null) {
			this.product.printItem();
		}
	}

	@Override
	public void setDiscount(Discount discount) {
		if(this.product != null) {
			this.product.setDiscount(discount);
		}
	}

	@Override
	public String toString() {
		if(this.product != null) {
			return this.product.toString();
		}
		return null;
	}
	
	@Override
	public String getCategory() {
		if(this.product != null) {
			return this.product.getCategory();
		}
		return null;
	}

	@Override
	public String getDescription(){
		if(this.product != null){
			return this.product.getDescription();
		}
		return null;
	}
	
	public abstract void accept(Visitor visitor);
	public abstract double getPrice();	
}
