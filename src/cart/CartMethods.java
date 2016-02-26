package cart;

import item.Item;

public interface CartMethods extends CartBase {
	void addToCart(Item item, int quantity);
	String cartContents();
	String cartTotal();
	void printCart();
	void removeFromCart(Item item, int quantity);
}
