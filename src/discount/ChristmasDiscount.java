package discount;

public class ChristmasDiscount extends AbstractDiscount {
	private double percentage;
	
	public ChristmasDiscount(double percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public double getPercentage() {
		return percentage;
	}
	
	@Override
	public double calcDiscount(double price, double percentage) {
		return price-((price*percentage)/100);
	}

	@Override
	String discountDescription() {
		return "Christmas Discount";
	}
}
