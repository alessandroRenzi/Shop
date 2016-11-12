package payment;

public class Cash extends AbstractPayment {
	public Cash(Payment payment) {
		super(payment);
	}

	@Override
	public void doPay() {
		this.cashPay(); 
		super.doPay();
	}

	public void cashPay() {
		String temp = "Paid in cash: ";
		super.getPayment().setPay(temp);
	}
}
