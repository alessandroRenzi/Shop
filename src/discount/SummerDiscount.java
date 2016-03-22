package discount;

public class SummerDiscount extends AbstractDiscount {
	private double percentage;

	public SummerDiscount(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public double getPercentage() {
		return percentage;
	}

	@Override
	public double calcDiscount(double price) {
		return price-((price*percentage)/100);
	}

	@Override
	public String discountDescription() {
		return "Summer discount";
	}
}
