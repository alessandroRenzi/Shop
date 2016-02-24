package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.BankTransfer;
import payment.ConcretePayment;
import payment.Payment;

public class BankTransferTest {
	private ByteArrayOutputStream outContent;
	private Payment payment;
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","9-1-1944"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili",7.50),1);

		payment = new BankTransfer(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testBankTransfer() {
		payment.doPay();
		assertEquals("Paid by bank transfer: 7.5",outContent.toString());
	}
}
