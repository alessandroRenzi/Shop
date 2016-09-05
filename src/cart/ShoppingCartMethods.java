package cart;

import java.util.Iterator;

import customer.Customer;
import item.Item;

public abstract class ShoppingCartMethods extends ShoppingCartBase implements CartMethods {	
	public ShoppingCartMethods(Customer customer) {
		super(customer);
	}

	@Override
	public void addToCart(Item item, int quantity) throws Exception {
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
			item.setQuantity(quantity);
			getCart().add(item);
		}
		notifyAllObservers(0, item, quantity);
	}

	@Override
	public String cartContents() {
		String content = "";
		Iterator<Item> iteratorCart = this.getIterator();

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();
			content = content + currentItem.toString() + "\n";
		}
		return content;
	}

	@Override
	public String cartTotal() {
		String content = "Total quantity: " + getQuantityItems() + "\tTotal price: " + getTotalPrice();
		return content;
	}

	@Override
	public String toString() {
		return cartContents()+cartTotal();
	}

	@Override
	public void printCart() {
		System.out.print(toString());
	}

	@Override
	public void removeFromCart(Item item, int quantity) throws Exception {
		Iterator<Item> iteratorCart = this.getIterator();
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
