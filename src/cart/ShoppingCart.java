package cart;

import java.util.Iterator;

import customer.Customer;
import item.Item;
import observer.Observer;
import observer.TotalPrice;
import observer.TotalQuantity;

public class ShoppingCart extends ShoppingCartObserver implements Cart {
	public ShoppingCart(Customer customer) {
		super(customer);
		new TotalPrice(this);
		new TotalQuantity(this);
	}

	@Override
	public void notifyAllObservers(int index, Item item, int quantity) {
		for(Observer observer : getListObserver()) {
			observer.update(this,index,item,quantity);
		}
	}

	@Override
	public Iterator<Item> getItemIterator() {
		return this.getIterator();
	}
}
