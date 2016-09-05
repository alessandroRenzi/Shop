package util.rentals;

import java.time.LocalDate;

public class GoldRentalCalc extends AbsRentalCalc  {
	private static final int MPARAM = 150; 

	public GoldRentalCalc(LocalDate date) {
		super(date);
	}

	@Override
	public int getParameter() {
		return GoldRentalCalc.MPARAM;	
	}
}
