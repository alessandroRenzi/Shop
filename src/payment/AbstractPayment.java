package payment;

public abstract class AbstractPayment implements Payment {
	private Payment payment;

	public AbstractPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public void doPay() {
		if(this.payment != null) {
			this.payment.doPay();
		}
	}
}
