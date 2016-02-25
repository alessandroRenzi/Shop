package utilRentals;

public class FullRentalCalc extends AbsRentalCalc  {
	private final int MPARAM = 100;
	
	public FullRentalCalc (){
		super();
	}

	@Override
	public int getParameter() {
		return this.MPARAM;
	}

}
