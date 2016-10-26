package item;

import category.Category;
import discount.Discount;
import report.Visitor;

public interface Item extends Comparable<Item>{
	static final double ROUNDING = Math.pow(10,2);
	
	@Override
	public default int compareTo(Item itemToCompare) {
		int result = 0;
		if(this.getPrice() > itemToCompare.getPrice()) {
			result = 1;
		} else if (this.getPrice() < itemToCompare.getPrice()) {
			result = -1;
		}
		return result;
	}
	
	public default boolean equals(Item item) throws Exception {
		boolean result = false;
		
		if(this.getDescription().equals(item.getDescription())) {
			result = true;
		}
		return result;
	}
	
	public default double roundingPrice(Discount discount, double sum) {
		double discountedSum = discount.doDiscount(sum);
		return Math.round(discountedSum*ROUNDING)/ROUNDING;
	}

	void accept(Visitor visitor) throws Exception;
	void addItem(Item item) throws Exception;
	Category getCategory() throws Exception;
	String getDescription() throws Exception;
	Discount getDiscount();
	double getPrice();
	int getQuantity() throws Exception;
	void printItem();
	void removeItem(Item item) throws Exception;
	void setDiscount(Discount discount);
	void setQuantity(int quantity);
}

