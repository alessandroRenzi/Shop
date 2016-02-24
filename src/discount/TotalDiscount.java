package discount;

public class TotalDiscount extends AbstractDiscount {
	
	public TotalDiscount() {
	}
	
	@Override
	public double getPercentage() {
		return 100;
	}
	
	@Override
	public double calcDiscount(double price, double percentage) {
		return 0;
	}
}
