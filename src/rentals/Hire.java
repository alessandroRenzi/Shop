package rentals;

import java.time.LocalDate;

import utilRentals.CalcRental;

public interface Hire {
	LocalDate getRentalStartDate();
	void setRentalStartDate(String rentalStartDate);
	double rentalPriceCalc();
	void setTypeOfRental(CalcRental rentalType);
	void setEndRentalDate(LocalDate endRentalDate);
}