package utilInvoice;

public interface TaxCalculator {
	public double taxCalculate(double price, int vat);
	public double taxable(double price, int vat);
}
