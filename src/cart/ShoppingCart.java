package cart;

import customer.Customer;
import item.Item;
import observer.Observer;
import observer.TotalPriceObserver;
import observer.TotalQuantityObserver;

public class ShoppingCart extends ShoppingCartObserver implements Cart {
	public ShoppingCart(Customer customer) {
		super(customer);
		new TotalPriceObserver(this);
		new TotalQuantityObserver(this);
	}

	@Override
	public void notifyAllObservers(int index, Item item, int quantity) {
		for(Observer observer : getListObserver()) {
			observer.update(this,index,item,quantity);
		}
	}
}
