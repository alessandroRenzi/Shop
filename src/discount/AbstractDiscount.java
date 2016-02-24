package discount;

public abstract class AbstractDiscount implements Discount {
	public double doDiscount(double price, double percentage) {
		return calcDiscount(price,percentage);
	}

	abstract double calcDiscount(double price, double percentage);
}
