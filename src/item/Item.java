package item;

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
	String getCategory();
	double getPrice();
	void print();
}

