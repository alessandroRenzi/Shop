package utilRentals;

public class GoldRentalCalc extends AbsRentalCalc  {
	private final int MPARAM = 150; 
	
	public GoldRentalCalc(){
		super();
	}

	@Override
	public int getParameter() {
		return this.MPARAM;
		
	}
}
