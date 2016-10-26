package test.transaction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cart.Cart;
import cart.ShoppingCart;
import category.ConcreteCategory;
import customer.Customer;
import customer.UnRegisteredCustomer;
import item.ConcreteProduct;
import item.Item;
import payment.Cash;
import payment.ConcretePayment;
import payment.CreditCard;
import payment.Payment;
import transaction.ShopTransaction;
import transaction.Transaction;

public class ShopTransactionTest {
	private Customer customer;
	private Item item;
	private Payment kindPayment;
	private Cart shoppingCart;
	private Transaction transaction;
	
	@Before
	public void setUp() throws Exception {
		this.customer = new UnRegisteredCustomer("Jerry", "Cantrell", "1966-03-18");
		this.item = new ConcreteProduct("Harvest - Neil Young - Audio CD",  new ConcreteCategory("CDs & Vinyl"), 8.30);
		
		this.shoppingCart = new ShoppingCart(customer);
		this.shoppingCart.addToCart(item, 1);

		this.kindPayment = new CreditCard(new ConcretePayment(shoppingCart.getTotalPrice()));
		this.transaction = new ShopTransaction(kindPayment);
	}
	
	@Test
	public void testSalesTransactionTest(){
		transaction.salesTransaction();
		assertEquals("Paid with credit card: 8.3",transaction.getTransaction());
	}
	
	@Test
	public void testSetPayment() {
		this.transaction.setPayment(new Cash(new ConcretePayment(shoppingCart.getTotalPrice())));
		this.transaction.salesTransaction();
		assertEquals("Paid in cash: 8.3",transaction.getTransaction());
	}

}
