package util.invoice;

public class ShopTaxCalculator implements TaxCalculator {
	private static final double ROUNDING = Math.pow(10,2);

	public ShopTaxCalculator(){
		super();
	}
	
	@Override
	public double taxCalculate(double price, int vat) {
		double tax = (price*(vat))/100;
		return Math.round(tax*ROUNDING)/ROUNDING;
	}

	@Override
	public double taxable(double price, int vat) {
		double taxable = (price*(100-vat))/100;
		return Math.round(taxable*ROUNDING)/ROUNDING;
	}

}
