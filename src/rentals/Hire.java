package rentals;

import java.time.LocalDate;

import utilRentals.calcRental;

public interface Hire {

	public LocalDate getRentalStartDate();

	public void setRentalStartDate(String rentalStartDate);

	public double rentalPriceCalc();

	public void setTypeOfRental(calcRental rentalType);
	
	public void setEndRentalDate(LocalDate endRentalDate);
}