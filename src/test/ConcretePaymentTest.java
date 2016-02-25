package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import cart.Cart;
import cart.ShoppingCart;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.ConcretePayment;
import payment.Payment;

public class ConcretePaymentTest {
	private ByteArrayOutputStream outContent;
	private Payment payment;
	private Cart shoppingCart;

	@Before
	public void setUp() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("Jimmy Page","M","1944-01-09"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili", 7.50),1);

		payment = new ConcretePayment(shoppingCart.getTotalPrice());
	}

	@Test
	public void testRental() {
		payment.doPay();
		assertEquals("7.5",outContent.toString());
	}
}
