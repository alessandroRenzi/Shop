package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cart.Cart;
import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.ConcretePayment;
import payment.PayPal;
import payment.Payment;

public class PayPalTest {
	private Payment payment;
	private Cart shoppingCart;

	@Before
	public void setUp() {



		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("Jimmy Page","M","1944-09-19"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"), 7.50),1);
		payment = new PayPal(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testPayPal() {
		payment.doPay();
		assertEquals("Paid by PayPal: 7.5", payment.getPay());
	}
	
}
