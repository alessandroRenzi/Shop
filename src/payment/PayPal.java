package payment;

public class PayPal extends AbstractPayment {
	public PayPal(Payment payment) {
		super(payment);
	}

	@Override
	public void doPay() {
		this.payPalPay();
		super.doPay();
	}

	public void payPalPay() {
		System.out.print("Paid by PayPal: ");
	}
}
