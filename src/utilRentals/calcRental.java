package utilRentals;

import java.time.LocalDate;

import item.Item;

public interface calcRental {
	
	public double calculate(LocalDate startDate, Item item);
	public int daysCalc(LocalDate startDate);
	public void setDate(LocalDate date);
}
