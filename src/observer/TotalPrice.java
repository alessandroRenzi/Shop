package observer;

import cart.Cart;
import item.Item;

public class TotalPrice extends AbstractCartObserver {
	public TotalPrice(Cart shoppingCart) {
		super(shoppingCart);
	}

	@Override
	public void update(Cart shoppingCart, int index, Item item, int quantity) {
		double totalPrice = shoppingCart.getTotalPrice();

		if(index != 0) {
			totalPrice = totalPrice-(item.getPrice()*quantity);
		} else {
			totalPrice = totalPrice+(item.getPrice()*quantity);
		}
		shoppingCart.setTotalPrice(totalPrice);
	}
}
