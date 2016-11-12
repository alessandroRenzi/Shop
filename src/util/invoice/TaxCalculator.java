package util.invoice;

public interface TaxCalculator {
	public double taxCalculate(double price, int vat);
	public double taxable(double price, int vat);
}
