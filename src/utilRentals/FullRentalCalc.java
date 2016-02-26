package utilRentals;

import java.time.LocalDate;

public class FullRentalCalc extends AbsRentalCalc  {
	private final int MPARAM = 100;
	
	public FullRentalCalc(LocalDate date){
		super(date);
	}

	@Override
	public int getParameter() {
		return this.MPARAM;
	}

}
