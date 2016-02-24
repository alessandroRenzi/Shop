package discount;

public class BaseDiscount extends AbstractDiscount {
	public BaseDiscount() {
		
	}
	
	@Override
	public double getPercentage() {
		return 0;
	}

	@Override
	public double calcDiscount(double price, double percentage) {
		return price;
	}
}
