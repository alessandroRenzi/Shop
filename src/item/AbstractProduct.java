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
	public Category getCategory() throws Exception {
		if(this.product.getCategory() == null) {
			throw new Exception("ATTENTION: An item must contain a category.");
		} else {
			return this.product.getCategory();
		}
	}

	@Override
	public String getDescription() throws Exception{
		if(this.product.getDescription() == null) {
			throw new Exception("ATTENTION: An item must contain a description.");
		} else {
			return this.product.getDescription();
		}
		
	}
	
	@Override
	public int getQuantity() throws Exception{
		if(this.product.getPrice() == 0) {
			throw new Exception("ATTENTION: An item must contain a quantity.");
		} else {
			return this.product.getQuantity();
		}
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
		String result = null;
		
		if(this.product != null) {
			result = this.product.toString();
		}
		return result;
	}
	
	public Discount getDiscount(){
		return this.product.getDiscount();
	}

	public abstract void accept(Visitor visitor) throws Exception;
	public abstract double getPrice();	
}
