package item;

import java.util.*;

import discount.Discount;
import report.Visitor;
import discount.BaseDiscount;

public class Composite implements Item {
	private String description;
	private List<Item> myItems;
	private Discount discount;

	public Composite(String description) {
		this.description = description;
		this.myItems = new LinkedList<Item>();
		setDiscount(new BaseDiscount());
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

	public void setMyItems(List<Item> myItems) {
		this.myItems = myItems;
	}

	public Discount getDiscount() {
		return discount;
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
		return discount.discount(sum);
	}

	@Override
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return getDescription() + " - price: " + getPrice();
	}

	public Iterator<Item> createIterator(){
		return myItems.iterator();
	}
}
