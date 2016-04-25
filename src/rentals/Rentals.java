package rentals;

import java.time.LocalDate;
import customer.Customer;
import item.Item;
import util.Rentals.CalcRental;
import util.Rentals.FullRentalCalc;

public class Rentals implements Hire {
	private LocalDate startRentalDate;
	private LocalDate endRentalDate;
	private Customer customer;
	private Item item;
	private CalcRental rentalCalculator;

	public Rentals(Customer customer, Item item, String date) {
		this.customer = customer;
		this.item = item;
		this.startRentalDate = LocalDate.parse(date);
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public LocalDate getRentalStartDate() {
		return startRentalDate;
	}
	
	public LocalDate getEndRentalDate() {
		return endRentalDate;
	}

	@Override
	public void setEndRentalDate(LocalDate endRentalDate) {
		this.endRentalDate = endRentalDate;
		this.setTypeOfRental(new FullRentalCalc(endRentalDate));
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
	public void setTypeOfRental(CalcRental rentalType) {
		this.rentalCalculator = rentalType;
	}
}
