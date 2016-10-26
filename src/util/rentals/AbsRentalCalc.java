package util.rentals;

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

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public double calculate(LocalDate startDate, Item item) {
		int parameter = this.getParameter();
		Item temp = item;
		
		double result = temp.getPrice();
		result = ((result*daysCalc(startDate))/parameter);
		
		return result;
	}

	@Override
	public int daysCalc(LocalDate startDate) {
		int result = getDate().getDayOfYear()-startDate.getDayOfYear();
		return result;
	}

	abstract int getParameter();
}