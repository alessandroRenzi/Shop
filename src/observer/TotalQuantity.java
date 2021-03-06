package observer;

import cart.Cart;
import item.Item;

public class TotalQuantity extends AbstractCartObserver {
	public TotalQuantity(Cart shoppingCart) {
		super(shoppingCart);
	}

	@Override
	public void update(Cart shoppingCart, int index, Item item, int quantity) {
		int totalQuantity = shoppingCart.getQuantityItems();

		if(index != 0) {
			totalQuantity = totalQuantity-quantity;
		} else {
			totalQuantity = totalQuantity+quantity;
		}
		shoppingCart.setQuantityItems(totalQuantity);
	}
}
