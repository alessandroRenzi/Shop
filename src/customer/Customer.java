package customer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import rentals.Rentals;

public class Customer {
	private static AtomicInteger counter = new AtomicInteger(0);

	private Calendar dateOfBirth;
	private List<Rentals> listRentals;
	private String genre;
	private String ID;
	private String nominative;

	public Customer(String nominative, String genre, int day, int month, int year) {
		this.dateOfBirth = new GregorianCalendar(year, month-1, day);
		this.listRentals = new LinkedList<Rentals>();
		this.genre = genre;
		this.ID = "CST" + counter.incrementAndGet();
		this.nominative = nominative;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNominative() {
		return nominative;
	}

	public void setNominative(String nominative) {
		this.nominative = nominative;
	}

	public List<Rentals> getListRentals() {
		return listRentals;
	}

	public String getID() {
		return ID;
	}

	@Override
	public String toString() {
		int month = getDateOfBirth().get(Calendar.MONTH);
		return "Customer n.: " + getID() + "| name: " + getNominative() + 
				"| genre: " + getGenre() + "| date of birth: " + getDateOfBirth().get(Calendar.DATE) + 
				"/" +  (month+1) + "/" +  getDateOfBirth().get(Calendar.YEAR);
	}

	public void addRentals(Rentals rentals) {
		this.listRentals.add(rentals);
	}

	public void removeRentals(Rentals rentals) {
		this.listRentals.remove(rentals);
	}
}
