package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import customer.Customer;
import item.ConcreteProduct;
import payment.ConcretePayment;
import payment.PayPal;
import payment.Payment;
import sales.ShoppingCart;

public class PayPalTest {
	private ByteArrayOutputStream outContent;
	private Payment payment;
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		shoppingCart = new ShoppingCart(new Customer("Jimmy Page","M",9,1,1944));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili", 7.50),1);

		payment = new PayPal(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testPayPal() {
		payment.doPay();
		assertEquals("Paid by PayPal: 7.5",outContent.toString());
	}
}
