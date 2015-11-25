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
		System.out.print("Paid by credit card: ");
	}
}
