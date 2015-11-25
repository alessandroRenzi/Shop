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
		System.out.print("Paid in cash: ");
	}
}
