package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.Cash;
import payment.ConcretePayment;
import payment.Payment;

public class CashPaymentTest {

	private Payment payment;
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","1944-09-03"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991", "CD e Vinili",7.50),1);

		payment = new Cash(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testBankTransfer() {
		payment.doPay();
		assertEquals("Paid in cash: 7.5",payment.getPay());
	}
}