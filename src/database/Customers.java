package database;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import customer.Customer;

public class Customers {
	private List<Customer> listRegister;

	public Customers() {
		listRegister = new LinkedList<Customer>();
	}

	public List<Customer> getListRegister() {
		return listRegister;
	}

	public void setListRegister(List<Customer> listRegister) {
		this.listRegister = listRegister;
	}

	public void addToListRegister(Customer registered) {
		this.listRegister.add(registered);
	}

	public void removeFromListRegister(Customer registered) {
		this.listRegister.remove(registered);
	}

	public void print() {
		Iterator<Customer> iteratorCustomers = listRegister.iterator();

		while(iteratorCustomers.hasNext()) {
			Customer currentCustomer = iteratorCustomers.next();
			System.out.println(currentCustomer.toString());
		}
	}
}
