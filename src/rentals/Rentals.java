package rentals;

import java.time.LocalDate;
import customer.Customer;
import item.Item;
import utilRentals.FullRentalCalc;
import utilRentals.calcRental;

public class Rentals implements Hire {
	private LocalDate startRentalDate;
	private Customer customer;
	private Item item;
	private calcRental rentalCalculator;

	public Rentals(Customer customer, Item item, String date) {
		this.customer = customer;
		this.item = item;
		this.startRentalDate = LocalDate.parse(date);
		this.setTypeOfRental(new FullRentalCalc());
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public LocalDate getRentalStartDate() {
		return startRentalDate;
	}

	@Override
	public void setRentalStartDate(String rentalStartDate) {
		startRentalDate = LocalDate.parse(rentalStartDate);
	}

	public Item getItem() {
		return item;
	}

	@Override
	public double rentalPriceCalc() {
		double result = 0;
		result = rentalCalculator.calculate(getRentalStartDate(), getItem());
		return result;
	}

	@Override
	public void setTypeOfRental(calcRental rentalType) {
		this.rentalCalculator = rentalType;
	}
}
