package discount;

public class GratisDiscount implements Discount {
	@Override
	public double discount(double price) {
		return 0;
	}
}
