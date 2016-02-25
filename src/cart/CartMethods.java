package cart;

import item.Item;

public interface CartMethods extends CartBase {
	void addToCart(Item item, int quantity);
	void cartContents();
	void cartTotal();
	void printCart();
	void removeFromCart(Item item, int quantity);
}
