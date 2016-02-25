package cart;

import java.util.LinkedList;
import java.util.List;

import customer.Customer;
import item.Item;

public abstract class ShoppingCartBase implements CartBase {
	private List<Item> cart;
	private Customer customer;
	private int quantityItems;
	private double totalPrice;

	public ShoppingCartBase(Customer customer) {
		this.cart = new LinkedList<Item>();
		this.customer = customer;
		this.quantityItems = 0;
		this.totalPrice = 0;
	}

	public List<Item> getCart() {
		return cart;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public int getQuantityItems() {
		return quantityItems;
	}

	@Override
	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public void setQuantityItems(int quantityItems) {
		this.quantityItems = quantityItems;
	}

	@Override
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
