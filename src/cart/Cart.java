package cart;

import java.util.Iterator;

import item.Item;

public interface Cart extends CartObserver {
	Iterator<Item> getItemIterator();
	
}
