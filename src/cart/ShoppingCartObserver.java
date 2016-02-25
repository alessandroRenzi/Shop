package cart;

import java.util.LinkedList;
import java.util.List;

import customer.Customer;
import item.Item;
import observer.Observer;

public abstract class ShoppingCartObserver extends ShoppingCartMethods implements CartObserver {
	private static List<Observer> listObserver;

	public ShoppingCartObserver(Customer customer) {
		super(customer);
		listObserver = new LinkedList<Observer>();
	}

	public static List<Observer> getListObserver() {
		return listObserver;
	}

	@Override
	public void addObserver(Observer observer) {
		listObserver.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		listObserver.remove(observer);
	}

	public abstract void notifyAllObservers(int index, Item item, int quantity);
}
