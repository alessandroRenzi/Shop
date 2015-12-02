package utility;

import sales.ShoppingCart;

public class ConcreteInvoice implements Invoice {
	private ShoppingCart shoppingCart;

	public ConcreteInvoice(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public void doInvoice() {

	}
}
