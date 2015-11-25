package rentals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import customer.Customer;
import item.Item;

public class Rentals {
	private Calendar rentalStartDate;
	private Customer customer;
	private Item item;

	public Rentals(Customer customer, Item item, int day, int month, int year) {
		this.customer = customer;
		this.item = item;
		this.rentalStartDate = new GregorianCalendar(year,month-1,day);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Calendar getRentalStartDate() {
		return rentalStartDate;
	}

	public void setRentalStartDate(Calendar rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}

	public Item getItem() {
		return item;
	}

	public double rentalPriceCalc() {
		double result = 0;
		Calendar dateOfToday = Calendar.getInstance();

		long dateInMillis = dateOfToday.getTimeInMillis() - this.rentalStartDate.getTimeInMillis();
		//1 giorno = 1000*60*60*24 ms = 86400000 ms
		long numberOfDays = dateInMillis/(86400000);
		result = numberOfDays*1;
		return result;
	}
}
