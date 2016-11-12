
package transaction;

import payment.Payment;

public interface Transaction {
	void setPayment(Payment payment);
	void salesTransaction();
	String getTransaction();
}
