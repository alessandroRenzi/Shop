package util.Invoice;

public class ShopTaxCalculator implements TaxCalculator {

	public ShopTaxCalculator(){
		super();
	}
	
	@Override
	public double taxCalculate(double price, int vat) {
		double rounding = Math.pow(10,2);
		double tax = (price*(vat))/100;
		return Math.round(tax*rounding)/rounding;
	}

	@Override
	public double taxable(double price, int vat) {
		double rounding = Math.pow(10,2);
		double taxable = (price*(100-vat))/100;
		return Math.round(taxable*rounding)/rounding;
	}

}
