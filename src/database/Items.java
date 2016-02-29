package database;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import item.ConcreteProduct;
import item.Item;

public class Items {
	private List<Item> listItems;

	public Items() {
		listItems = new LinkedList<Item>();
		initialItems();
	}

	public List<Item> getListItems() {
		return listItems;
	}

	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}

	public void addToListItems(Item item) {
		this.listItems.add(item);
	}

	public void removeFromListItems(Item item) {
		this.listItems.remove(item);
	}

	public void print() {
		Iterator<Item> iteratorItems = getIterator();

		while(iteratorItems.hasNext()) {
			Item currentCustomer = iteratorItems.next();
			System.out.println(currentCustomer.toString());
		}
	}
	
	public Iterator<Item> getIterator() {
		return listItems.iterator();
	}
	
	private void initialItems() {
		listItems.add(new ConcreteProduct("The Wall - Pink Floyd - 1979", "CD e Vinili", 24.41));
		listItems.add(new ConcreteProduct("Sixteen Stone - Bush - 1994", "CD e Vinili", 17.95));
	}
}
