package util.Rentals;

import java.time.LocalDate;

import item.Item;

public abstract class AbsRentalCalc implements CalcRental {
	private LocalDate date;
	
	public AbsRentalCalc(LocalDate date) {
		super();
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public double calculate(LocalDate startDate, Item item) {
		Item temp = item;
		int parameter = this.getParameter();
		double result = temp.getPrice();
		result = ((result*daysCalc(startDate))/parameter);
		return result;
	}

	@Override
	public int daysCalc(LocalDate startDate) {
		int result;
		result = getDate().getDayOfYear() - startDate.getDayOfYear();
		return result;
	}

	public abstract int getParameter();
}