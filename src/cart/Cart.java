package cart;

import java.util.Iterator;

import customer.Customer;
import item.Item;
import observer.Observer;

public interface Cart {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void addToCart(Item item, int quantity) throws Exception;
	void printCart();
	void removeFromCart(Item item, int quantity) throws Exception;
	Iterator<Item> iteratorItemList();
	Customer getCustomer();
	int getQuantityItems();
	double getTotalPrice();
	String cartContents();
	void setQuantityItems(int quantityItems);
	void setTotalPrice(double totalPrice);
}
