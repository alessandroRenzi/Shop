package test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.ConcretePayment;

public class ConcretePaymentTest {
	private ConcretePayment payment;
	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","1944-09-03"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991",  new ConcreteCategory("CD e Vinili"),7.50),1);

		payment = new ConcretePayment(shoppingCart.getTotalPrice());
	}

	@Test
	public void testBankTransfer() {
		payment.doPay();
		assertEquals("7.5",payment.getPay());
	}

	@Test
	public void testSetPay() {
		payment.setPay("8.5");
		assertEquals("8.5",payment.getPay());
	}
	
	@Test
	public void testGetTotalPrice() {
		assertEquals(7.5,payment.getTotalPrice(),1);
	}
}
