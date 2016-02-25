package cart;

import customer.Customer;

public interface CartBase {
	Customer getCustomer();
	int getQuantityItems();
	double getTotalPrice();
	void setQuantityItems(int quantityItems);
	void setTotalPrice(double totalPrice);
}
