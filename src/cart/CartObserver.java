package cart;

import item.Item;
import observer.Observer;

public interface CartObserver extends CartMethods {
	void addObserver(Observer observer);
	void notifyAllObservers(int index, Item item, int quantity);
	void removeObserver(Observer observer);
}
