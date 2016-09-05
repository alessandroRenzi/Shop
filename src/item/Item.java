package item;

import category.Category;
import discount.Discount;
import report.Visitor;

public interface Item extends Comparable<Item>{
	void accept(Visitor visitor);
	void add(Item item) throws Exception;

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
	
	public default boolean equals(Item item) {
		boolean result = false;
		
		if(this.getDescription().equals(item.getDescription())) {
			result = true;
		}
		return result;
	}

	String getDescription();
	double getPrice();
	void printItem();
	void remove(Item item) throws Exception;
	void setDiscount(Discount discount);
	Discount getDiscount();
	Category getCategory();
	int getQuantity();
	void setQuantity(int quantity);
}

