package database;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import customer.Customer;

public class Customers {
	private List<Customer> listCustomers;

	public Customers() {
		listCustomers = new LinkedList<Customer>();
	}

	public List<Customer> getListRegister() {
		return listCustomers;
	}

	public void addToListRegister(Customer registered) {
		this.listCustomers.add(registered);
	}

	public void removeFromListRegister(Customer registered) {
		this.listCustomers.remove(registered);
	}

	public void print() {
		Iterator<Customer> iteratorCustomers = listCustomers.iterator();

		System.out.print("Customers:\n");
		while(iteratorCustomers.hasNext()) {
			Customer currentCustomer = iteratorCustomers.next();
			System.out.print(currentCustomer.toString() + "\n");
		}
	}
}
