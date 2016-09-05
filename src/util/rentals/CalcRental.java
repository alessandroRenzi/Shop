package util.rentals;

import java.time.LocalDate;

import item.Item;

public interface CalcRental {
	double calculate(LocalDate startDate, Item item);
	int daysCalc(LocalDate startDate);
	void setDate(LocalDate date);
}
