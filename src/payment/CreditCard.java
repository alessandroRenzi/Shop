package payment;

public class CreditCard extends AbstractPayment {

	public CreditCard(Payment payment) {
		super(payment);
	}

	@Override 
	public void doPay() {
		 this.cashPay();
		 super.doPay();
	}

	public void cashPay() {
		String temp = "Paid with credit card: ";
		super.getPayment().setPay(temp);
	}

}
