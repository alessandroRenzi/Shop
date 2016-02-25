
package transaction;

import payment.Payment;

public interface Transaction {

	public void setPayment(Payment payment);

	public void salesTransaction();
	
	public String getTransaction();
}
