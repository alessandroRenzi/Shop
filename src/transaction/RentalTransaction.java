package transaction;

import payment.Payment;
import rentals.Hire;

public class RentalTransaction extends AbsTransaction {
	public RentalTransaction(Payment payment, Hire rental){
		super(payment);
	}
}
