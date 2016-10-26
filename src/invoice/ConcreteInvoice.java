package invoice;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import cart.Cart;

public class ConcreteInvoice extends AbstractInvoice {
	private static AtomicInteger counter = new AtomicInteger(0);
	private String invoiceNumber;

	public ConcreteInvoice(Cart shoppingCart) {
		super(shoppingCart);
		this.invoiceNumber = "" + counter.incrementAndGet();
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public String invoiceDetails() {
		String content = "Fattura n: " + getInvoiceNumber() + " | Data: " + LocalDate.now();
		return content;
	}

	public String itemsDetails() {
		String content = "Items:\n" + getShoppingCart().cartContents()
				+ "\nTaxable: " + taxable(getShoppingCart().getTotalPrice()) 
				+ "\nVAT tax: " + tax(getShoppingCart().getTotalPrice()) 
				+ "\nTotal amount: " + getShoppingCart().getTotalPrice();
		return content;
	}
	
	public void resetInvoiceNumber() {
		counter.set(0);
	}
}
