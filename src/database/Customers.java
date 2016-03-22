package database;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import customer.Customer;
import customer.UnRegisteredCustomer;

public class Customers {
	private List<Customer> listCustomers;

	public Customers() {
		listCustomers = new LinkedList<Customer>();
		this.listCustomers.add(new UnRegisteredCustomer("Blank","Blank","1985-04-26"));
	}

	public List<Customer> getListRegister() {
		return listCustomers;
	}

	public void setListRegister(List<Customer> listRegister) {
		this.listCustomers = listRegister;
	}

	public void addToListRegister(Customer registered) {
		this.listCustomers.add(registered);
	}

	public void removeFromListRegister(Customer registered) {
		this.listCustomers.remove(registered);
	}

	public void print() {
		Iterator<Customer> iteratorCustomers = listCustomers.iterator();

		while(iteratorCustomers.hasNext()) {
			Customer currentCustomer = iteratorCustomers.next();
			System.out.println(currentCustomer.toString());
		}
	}
}
