package item;

import java.util.*;

import discount.BaseDiscount;
import discount.Discount;
import report.Visitor;

public class Composite implements Item {
	private String description;
	private Discount discount;
	private List<Item> myItems;

	public Composite(String description) {
		this.description = description;
		this.discount = new BaseDiscount();
		this.myItems = new LinkedList<Item>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getMyItems() {
		return myItems;
	}

	@Override
	public void accept(Visitor v) {
		v.visitComposite(this);
	}

	@Override
	public void add(Item item) throws Exception {
		myItems.add(item);
	}

	@Override
	public double getPrice() {
		double sum = 0;
		Iterator<Item> iteratorItems = createIterator();

		while(iteratorItems.hasNext()) {
			Item currentItem = iteratorItems.next();
			sum = sum+currentItem.getPrice();
		}
		return roundingPrice(sum);
	}

	@Override
	public void print() {
		System.out.print(getDescription() + " - price: " + getPrice());
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Iterator<Item> createIterator(){
		return myItems.iterator();
	}

	public double roundingPrice(double sum) {
		double discountedSum = discount.doDiscount(sum,discount.getPercentage());
		double rounding = Math.pow(10,2);
		return Math.round(discountedSum*rounding)/rounding;
	}
}
