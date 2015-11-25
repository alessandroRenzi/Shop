package discount;

public class BaseDiscount implements Discount {
	public double discount(double price) {
		return price;
	}
}
