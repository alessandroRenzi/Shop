package util.rentals;

import java.time.LocalDate;

public class FullRentalCalc extends AbsRentalCalc  {
	private static final int MPARAM = 100;

	public FullRentalCalc(LocalDate date) {
		super(date);
	}

	@Override
	public int getParameter() {
		return FullRentalCalc.MPARAM;
	}
}
