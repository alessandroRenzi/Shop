package item;

import discount.Discount;
import report.Visitor;

public interface Item extends Comparable<Item>{
	void accept(Visitor visitor);
	void add(Item item) throws Exception;

	public default int compareTo(Item itemToCompare) {
		int result = 0;
		if(this.getPrice() > itemToCompare.getPrice()) {
			result = 1;
		} else if (this.getPrice() < itemToCompare.getPrice()) {
			result = -1;
		}
		return result;
	}

	double getPrice();
	void print();
	void setDiscount(Discount discount);
}

