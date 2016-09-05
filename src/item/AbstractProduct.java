package item;

import category.Category;
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
	public Category getCategory() {
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
	
	@Override
	public int getQuantity(){
		if(this.product != null){
			return this.product.getQuantity();
		}
		return -1;
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
	public void setQuantity(int quantity) {
		if(this.product != null) {
			this.product.setQuantity(quantity);
		}
	}

	@Override
	public String toString() {
		if(this.product != null) {
			return this.product.toString();
		}
		return null;
	}
	
	public Discount getDiscount(){
		return this.product.getDiscount();
	}

	public abstract void accept(Visitor visitor);
	public abstract double getPrice();	
}
