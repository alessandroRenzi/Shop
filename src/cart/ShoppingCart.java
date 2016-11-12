package cart;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import customer.Customer;
import item.Item;
import observer.Observer;
import observer.TotalPrice;
import observer.TotalQuantity;

public class ShoppingCart implements Cart {
	private static List<Observer> listObserver;
	private static final double ROUNDING = Math.pow(10,2);
	
	private Customer customer;
	private List<Item> listItem;
	private int quantityItems;
	private double totalPrice;
	
	public ShoppingCart(Customer customer) {		
		this.customer = customer;
		this.listItem = new LinkedList<Item>();
		listObserver = new LinkedList<Observer>();
		this.quantityItems = 0;
		this.totalPrice = 0;
		
		new TotalPrice(this);
		new TotalQuantity(this);
	}
	
	@Override
	public Customer getCustomer() {
		return this.customer;
	}

	public List<Item> getListItem() {
		return this.listItem;
	}

	public static List<Observer> getListObserver() {
		return listObserver;
	}
	
	@Override
	public int getQuantityItems() {
		return quantityItems;
	}
	
	@Override
	public double getTotalPrice() {
		return Math.round(totalPrice*ROUNDING)/ROUNDING;
	}
	
	@Override
	public void setQuantityItems(int quantityItems) {
		this.quantityItems = quantityItems;
	}

	@Override
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public void addObserver(Observer observer) {
		listObserver.add(observer);
	}
	
	@Override
	public void addToCart(Item item, int quantity) throws Exception {
		Iterator<Item> iteratorCart = this.iteratorItemList();
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
			this.listItem.add(item);
		}
		notifyAllObservers(0, item, quantity);
	}
	
	@Override
	public String cartContents() {
		String content = "";
		Iterator<Item> iteratorCart = this.iteratorItemList();

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();
			content = content+currentItem.toString()+"\n";
		}
		return content;
	}
	
	private String cartTotal() {
		String content = "Total quantity: "+getQuantityItems()+"\tTotal price: "+getTotalPrice();
		return content;
	}
	
	@Override
	public Iterator<Item> iteratorItemList() {
		return this.listItem.iterator();
	}
	
	private void notifyAllObservers(int index, Item item, int quantity) {
		for(Observer observer : getListObserver()) {
			observer.update(this,index,item,quantity);
		}
	}

	@Override
	public void printCart() {
		String stringCart = this.cartContents()+this.cartTotal();
		System.out.print(stringCart);
	}

	@Override
	public void removeFromCart(Item item, int quantity) throws Exception {
		Iterator<Item> iteratorCart = this.iteratorItemList();
		boolean result = false;

		while(iteratorCart.hasNext()) {
			Item currentItem = iteratorCart.next();

			if(item.equals(currentItem)) {
				currentItem.setQuantity(currentItem.getQuantity()-quantity);
				result = true;
			}
		}
		if(!result) {
			this.listItem.remove(quantity);
		}
		notifyAllObservers(1,item,quantity);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		listObserver.remove(observer);
	}
}
