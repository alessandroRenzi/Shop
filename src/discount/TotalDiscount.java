package discount;

public class TotalDiscount extends AbstractDiscount {
	@Override
	public double getPercentage() {
		return 100;
	}

	@Override
	public double calcDiscount(double price) {
		return 0;
	}

	@Override
	public String discountDescription() {
		return "Total discount";
	}
}
