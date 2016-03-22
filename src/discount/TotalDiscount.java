package discount;

public class TotalDiscount extends AbstractDiscount {
	@Override
	public double getPercentage() {
		return 100;
	}

	@Override
	public double calcDiscount(double price, double percentage) {
		return 0;
	}

	@Override
	String discountDescription() {
		return "Total Discount";
	}
}
