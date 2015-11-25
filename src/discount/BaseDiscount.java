package discount;

public class BaseDiscount implements Discount {
	@Override
	public double discount(double price) {
		return price;
	}
}
