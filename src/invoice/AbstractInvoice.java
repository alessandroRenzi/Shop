package invoice;

import cart.Cart;
import database.Company;

public abstract class AbstractInvoice implements Invoice {
	private Company company = new Company();
	private Cart shoppingCart;
	private int vat = 22;

	public AbstractInvoice(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public Company getCompany() {
		return company;
	}

	public Cart getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public String doInvoice() {
		return invoiceDetails() + "\n\n" + companyInfo() + "\n\n" + customerInfo() + "\n\n" + itemsDetails();
	}

	private String companyInfo() {
		String content = getCompany().toString();
		return content;
	}

	private String customerInfo() {
		String content = "Customer:\n" + shoppingCart.getCustomer().toString();
		return content;
	}

	public double taxable(double totalPrice) {
		double rounding = Math.pow(10,2);
		double taxable = (totalPrice*(100-getVat()))/100;
		return Math.round(taxable*rounding)/rounding;
	}

	public double tax(double totalPrice) {
		double rounding = Math.pow(10,2);
		double tax = (totalPrice*(getVat()))/100;
		return Math.round(tax*rounding)/rounding;
	}

	abstract String invoiceDetails();
	abstract String itemsDetails();
}
