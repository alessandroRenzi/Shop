package discount;

public class TwentyPercDiscount implements Discount {
	private final int MAGTWENTY = 20;
	private final int MAGHUNDRED = 100;
	
	@Override
	public double discount(double price) {
		return price - ((price * MAGTWENTY )/MAGHUNDRED);
	}
}
