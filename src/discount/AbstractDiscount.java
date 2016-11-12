package discount;

public abstract class AbstractDiscount implements Discount {
	public double doDiscount(double price) {
		return calcDiscount(price);
	}

	@Override
	public String toString(){
		String result = "";
		result = discountDescription();
		return result;
	}
	
	abstract double calcDiscount(double price);
	abstract String discountDescription();
}
