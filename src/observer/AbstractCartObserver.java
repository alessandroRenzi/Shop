package observer;

import cart.Cart;
import item.Item;

public abstract class AbstractCartObserver implements CartObserver {
	public AbstractCartObserver(Cart shoppingCart) {
		shoppingCart.addObserver(this);
	}

	public abstract void update(Cart shoppingCart, int index, Item item, int quantity);
}
