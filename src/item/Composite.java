package item;

import java.util.*;

import report.Visitor;

public class Composite implements Item {
	private String description;
	private List<Item> myItems;

	public Composite(String description) {
		this.description = description;
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

	public void setMyItems(List<Item> myItems) {
		this.myItems = myItems;
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
		return sum;
	}

	@Override
	public void print() {
		System.out.print(getDescription() + " - price: " + getPrice());
	}

	public Iterator<Item> createIterator(){
		return myItems.iterator();
	}
}
