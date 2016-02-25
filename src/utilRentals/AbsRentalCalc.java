package utilRentals;

import java.time.LocalDate;

import item.Item;

public abstract class AbsRentalCalc implements calcRental {

	public AbsRentalCalc() {
		super();
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
		result = LocalDate.now().getDayOfYear() - startDate.getDayOfYear();
		return result;
	}

	public abstract int getParameter();
}