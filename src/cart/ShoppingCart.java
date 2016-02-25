package cart;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import customer.Customer;
import item.Item;
import observer.CartObserver;
import observer.TotalPriceObserver;
import observer.TotalQuantityObserver;

public class ShoppingCart implements Cart {
	private List<Item> cart;
	public static List<CartObserver> getListObserver() {
		return listObserver;
	}

	public CartObserver getTotalQuantityObserver() {
		return totalQuantityObserver;
	}

	public CartObserver getTotalPriceObserver() {
		return totalPriceObserver;
	}

	private Customer customer;
	private static List<CartObserver> listObserver;
	private int quantityItems;  
	private CartObserver totalQuantityObserver;
	private double totalPrice;
	private CartObserver totalPriceObserver;


	public ShoppingCart(Customer customer) {
		cart = new LinkedList<Item>();
		this.customer = customer;
		listObserver = new LinkedList<CartObserver>();
		this.quantityItems = 0;
		totalQuantityObserver = new TotalQuantityObserver(this);
		this.totalPrice = 0;
		totalPriceObserver = new TotalPriceObserver(this);
	}

	public List<Item> getCart() {
		return cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getQuantityItems() {
		return quantityItems;
	}

	public void setQuantityItems(int quantityItems) {
		this.quantityItems = quantityItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addToCart(Item item, int quantity) { 
		int quantityIndex = quantity;

		while(quantityIndex != 0) {
			cart.add(item);
			quantityIndex = quantityIndex-1;
		}
		notifyAllObservers(0,item,quantity);
	}

	public void removeFromCart(Item item, int quantity) {
		int quantityIndex = quantity;

		while(quantityIndex != 0) {
			cart.remove(item);
			quantityIndex = quantityIndex-1;
		}
		notifyAllObservers(1,item,quantity); 
	}

	public void printCart() {
		cartContents();
		cartTotal();
	}

	public void cartContents() {
		Iterator<Item> iteratorCart = getIterator();

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();
			currentItem.print();
			System.out.print("\n");
		}
	}

	public void cartTotal() {
		String content = "\nQuantity: " + getQuantityItems() + "\tTotal price: " + getTotalPrice();
		System.out.print(content);
	}

	public Iterator<Item> getIterator() {
		return cart.iterator();
	}

	public void addObserver(CartObserver observer) {
		listObserver.add(observer);
	}

	public void removeObserver(CartObserver observer) {
		listObserver.remove(observer);
	}

	public void notifyAllObservers(int index, Item item, int quantity) {
		for(CartObserver observer : listObserver) {
			observer.update(this,index,item,quantity);
		}
	}
}
