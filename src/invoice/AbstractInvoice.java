package invoice;

import cart.Cart;
import database.Company;

public abstract class AbstractInvoice implements Invoice {
	private static final double ROUNDING = Math.pow(10,2);
	
	private Company company = Company.getInstance();
	private Cart shoppingCart;
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
		return invoiceDetails() + "\n\n" + companyInfo() + "\n\n" + customerInfo() + "\n\n" + itemsDetails();
	}
	
	public double tax(double totalPrice) {
		double tax = (totalPrice*(getVat()))/100;
		return Math.round(tax*ROUNDING)/ROUNDING;
	}

	public double taxable(double totalPrice) {
		double taxable = (totalPrice*(100-getVat()))/100;
		return Math.round(taxable*ROUNDING)/ROUNDING;
	}

	abstract String invoiceDetails();
	abstract String itemsDetails();
}
