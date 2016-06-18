package cart;

import java.util.Iterator;

import customer.Customer;
import item.Item;

public abstract class ShoppingCartMethods extends ShoppingCartBase implements CartMethods {	
	public ShoppingCartMethods(Customer customer) {
		super(customer);
	}

	@Override
	public void addToCart(Item item, int quantity) {
		Iterator<Item> iteratorCart = getIterator();
		boolean result = false;

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();

			if(item.equals(currentItem)) {
				currentItem.setQuantity(currentItem.getQuantity()+quantity);
				result = true;
			}
		}
		if(!result) {
			getCart().add(item);
		}
		notifyAllObservers(0,item,quantity);
	}

	@Override
	public String cartContents() {
		String content = "";
		Iterator<Item> iteratorCart = getIterator();

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();
			content = content + currentItem.toString() + " | Quantity: " + currentItem.getQuantity() + "\n";
		}
		return content;
	}

	@Override
	public String cartTotal() {
		String content = "\nQuantity: " + getQuantityItems() + "\tTotal price: " + getTotalPrice();
		return content;
	}

	@Override
	public String toString() {
		return cartContents()+cartTotal();
	}

	@Override
	public void printCart() {
		System.out.print(this.toString());
	}

	@Override
	public void removeFromCart(Item item, int quantity) {
		Iterator<Item> iteratorCart = getIterator();
		boolean result = false;

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();

			if(item.equals(currentItem)) {
				currentItem.setQuantity(currentItem.getQuantity()-quantity);
				result = true;
			}
		}

		if(!result) {
			getCart().remove(item);
		}
		notifyAllObservers(1,item,quantity);
	}

	abstract void notifyAllObservers(int index, Item item, int quantity);
}
