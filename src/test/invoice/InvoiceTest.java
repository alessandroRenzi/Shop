package test.invoice;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import invoice.ConcreteInvoice;
import item.ConcreteProduct;

public class InvoiceTest {
	private Customer customer;
	private ConcreteInvoice invoice;
	private ByteArrayOutputStream outContent;
	private ConcreteProduct product1;
	private ConcreteProduct product2;
	private ShoppingCart shopCart;

	@After
	public void resetInvoiceNumber() {
		invoice.resetInvoiceNumber();
	}
	
	@Before
	public void setUp() throws Exception {
		customer = new UnRegisteredCustomer("Duane Allman","Male","1946-11-20");

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		this.product1 = new ConcreteProduct("Crossroads - Eric Clapton - 1988", new ConcreteCategory("CD e Vinili"), 24.00);
		this.product2 = new ConcreteProduct("Second Helping - Lynyrd Skynyrd - 1974", new ConcreteCategory("CD e Vinili"), 8.83);

		this.shopCart = new ShoppingCart(this.customer);
		this.shopCart.addToCart(this.product1,1);
		this.shopCart.addToCart(this.product2,2);

		this.invoice = new ConcreteInvoice(this.shopCart);
	}

	@Test
	public void testGetInvoiceNumber() {
		assertEquals("1", this.invoice.getInvoiceNumber());
	}

	@Test
	public void testInvoiceDetails() {
		LocalDate date = LocalDate.now();
		String content = "Fattura n: 1 | Data: " + date;
		assertEquals(content, this.invoice.invoiceDetails());
	}	

	@Test
	public void testGetVat() {
		assertEquals(22, this.invoice.getVat());
	}

	@Test
	public void testSetVat() {
		this.invoice.setVat(21);
		assertEquals(21, this.invoice.getVat());
	}

	@Test
	public void testGetCompany() {
		this.invoice.getCompany().printCompany();
		assertEquals("G&R Megastore di Gori M. e Renzi A.\n" +
				"Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy\n"+
				"Tel: 055.653258 - Fax: 055.653126\n" +
				"VAT: 00231500246 - E-mail: gerMegastore@gmail.com", this.outContent.toString());
	}

	@Test
	public void testGetShoppingCart() {
		this.invoice.getShoppingCart().printCart();
		assertEquals("Description: Crossroads - Eric Clapton - 1988 | Category: CD e Vinili | Price: 24.0 | Quantity: 1" + "\n" 
				+ "Description: Second Helping - Lynyrd Skynyrd - 1974 | Category: CD e Vinili | Price: 8.83 | Quantity: 2" + "\n"
				+ "Total quantity: 3" + "\tTotal price: 41.66", this.outContent.toString());
	}

	@Test
	public void testDoInvoice() {
		LocalDate date = LocalDate.now();
		String content = "Fattura n: 1 | Data: " + date;
		content = content + "\n\n" + "G&R Megastore di Gori M. e Renzi A.\n" +
				"Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy\n"+
				"Tel: 055.653258 - Fax: 055.653126\n" +
				"VAT: 00231500246 - E-mail: gerMegastore@gmail.com" + "\n\n" +  
				"Customer:\n" + "Nominative: Duane Allman | Genre: Male | Age: 71" + "\n\n" + "Items:\n" +
				"Description: Crossroads - Eric Clapton - 1988 | Category: CD e Vinili | Price: 24.0 | Quantity: 1" + "\n" +
				"Description: Second Helping - Lynyrd Skynyrd - 1974 | Category: CD e Vinili | Price: 8.83 | Quantity: 2" + "\n\n"
				+ "Taxable: 32.49\n"
				+ "VAT tax: 9.17\n"
				+ "Total amount: 41.66";
		this.invoice.doInvoice();
		assertEquals(content, this.invoice.doInvoice());
	}

	@Test
	public void testTaxable() {
		assertEquals(32.49, this.invoice.taxable(41.66),0.1);
	}

	@Test
	public void testTax() {
		assertEquals(9.17, this.invoice.tax(41.66),0.1);
	}
}
