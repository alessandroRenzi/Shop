package cart;

import customer.Customer;
import item.Item;
import observer.CartObserver;

public interface Cart {
	void addToCart(Item item, int quantity);
	double getTotalPrice();
	void printCart();
	void removeFromCart(Item item, int quantity);
	void addObserver(CartObserver observer);
	void removeObserver(CartObserver observer);
	void notifyAllObservers(int index, Item item, int quantity);
	void setTotalPrice(double totalPrice);
	int getQuantityItems();
	void setQuantityItems(int quantityItems);
	Customer getCustomer();
	void cartContents();
	void cartTotal();
}
