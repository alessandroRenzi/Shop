package invoice;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import cart.ShoppingCart;
import database.Company;

public class ConcreteInvoice implements Invoice {
	private static AtomicInteger counter = new AtomicInteger(0);
	private Company company = new Company();
	private String invoiceNumber;
	private ShoppingCart shoppingCart;
	private int vat = 22;

	public ConcreteInvoice(ShoppingCart shoppingCart) {
		this.invoiceNumber = "" + counter.incrementAndGet();
		this.shoppingCart = shoppingCart;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	@Override
	public void doInvoice() {
		invoiceDetails();
		companyInfo();
		itemsDetails();
	}

	public void customerInfo() {

	}

	public void invoiceDetails() {
		String content = "Invoice n: " + getInvoiceNumber() + " | Date: " + LocalDate.now() + "\n";
		System.out.println(content);
	}

	public void companyInfo() {
		company.printCompanyInfo();
		System.out.print("\n");
	}

	public void itemsDetails() {
		shoppingCart.cartContents();
		System.out.print("\n" + "Taxable: " + taxable(shoppingCart.getTotalPrice()));
		System.out.print("\n" + "VAT: " + tax(shoppingCart.getTotalPrice()));
		shoppingCart.cartTotal();
	}

	public double taxable(double totalPrice) {
		double rounding = Math.pow(10,2);
		double taxable = (totalPrice*(100-vat))/100;
		return Math.round(taxable*rounding)/rounding;
	}

	public double tax(double totalPrice) {
		double rounding = Math.pow(10,2);
		double tax = (totalPrice*(vat))/100;
		return Math.round(tax*rounding)/rounding;
	}
}
