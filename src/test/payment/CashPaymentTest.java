package test.payment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.Cash;
import payment.ConcretePayment;
import payment.Payment;

public class CashPaymentTest {

	private Payment payment;
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() throws Exception {
		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","1944-09-03"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"),7.50),1);

		payment = new Cash(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testBankTransfer() {
		payment.doPay();
		assertEquals("Paid in cash: 7.5",payment.getPay());
	}
	
	@Test
	public void testSetPay() {
		payment.setPay("8.5");
		assertEquals("8.5",payment.getPay());
	}
}
