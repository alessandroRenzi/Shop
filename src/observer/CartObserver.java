package observer;

import cart.Cart;
import item.Item;

public interface CartObserver {
	void update(Cart shoppingCart, int index, Item item, int quantity);
}
