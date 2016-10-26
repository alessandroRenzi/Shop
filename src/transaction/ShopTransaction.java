package transaction;

import payment.Payment;

public class ShopTransaction extends AbsTransaction {
	public ShopTransaction(Payment payment) {
		super(payment);
	}
}
