package discount;

public class BaseDiscount extends AbstractDiscount {	
	@Override
	public double getPercentage() {
		return 0;
	}

	@Override
	public double calcDiscount(double price) {
		return price;
	}

	@Override
	public String discountDescription() {
		return "Base discount";
	}
}
