package invoice;

import cart.Cart;
import database.Company;
import util.invoice.ShopTaxCalculator;
import util.invoice.TaxCalculator;

public abstract class AbstractInvoice implements Invoice {
	private Company company = Company.getInstance();
	private Cart shoppingCart;
	private TaxCalculator taxCalculator = new ShopTaxCalculator();
	private int vat = 22; 

	public AbstractInvoice(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public Cart getShoppingCart() {
		return shoppingCart;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}
	
	private String companyInfo() {
		String content = getCompany().toString();
		return content;
	}

	private String customerInfo() {
		String content = "Customer:\n" + shoppingCart.getCustomer().toString();
		return content;
	}
	
	@Override
	public String doInvoice() {
		String doInvoce = invoiceDetails() + "\n\n" + companyInfo() + "\n\n" + customerInfo() + "\n\n" + itemsDetails();
		return doInvoce;
	}
	
	public double tax(double totalPrice) {
		double resulTax = this.taxCalculator.taxCalculate(totalPrice, getVat());
		return resulTax;
	}

	public double taxable(double totalPrice) {
		double resulTaxable = this.taxCalculator.taxable(totalPrice, getVat());
		return resulTaxable;
	}

	abstract String invoiceDetails();
	abstract String itemsDetails();
}
