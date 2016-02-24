package discount;

public interface Discount {
	double doDiscount(double price, double percentage);
	double getPercentage();
}
