package util.Rentals;

import java.time.LocalDate;

public class GoldRentalCalc extends AbsRentalCalc  {
	private final int MPARAM = 150; 

	public GoldRentalCalc(LocalDate date){
		super(date);
	}

	@Override
	public int getParameter() {
		return this.MPARAM;	
	}
}
