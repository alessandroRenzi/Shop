package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cart.Cart;
import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import payment.BankTransfer;
import payment.ConcretePayment;
import payment.Payment;

public class BankTransferTest {
	private Payment payment;
	private Cart shoppingCart;

	@Before
	public void setUp() {

		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","1944-09-03"));
		shoppingCart = new ShoppingCart(new UnRegisteredCustomer("DA","M","1944-01-09"));
		shoppingCart.addToCart(new ConcreteProduct("Ten - Pearl Jam - 1991", new ConcreteCategory("CD e Vinili"),7.50),1);
		payment = new BankTransfer(new ConcretePayment(shoppingCart.getTotalPrice()));
	}

	@Test
	public void testBankTransfer() {
		payment.doPay();
		assertEquals("Paid by bank transfer: 7.5",payment.getPay());
	}
}
