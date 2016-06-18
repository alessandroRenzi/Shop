package cart;

import java.util.List;

import customer.Customer;
import item.Item;

public interface CartBase {
	List<Item> getCart();
	Customer getCustomer();
	int getQuantityItems();
	double getTotalPrice();
	void setQuantityItems(int quantityItems);
	void setTotalPrice(double totalPrice);
}
