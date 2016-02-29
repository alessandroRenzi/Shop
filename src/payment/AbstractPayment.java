package payment;

public abstract class AbstractPayment implements Payment {
	private Payment payment;

	public AbstractPayment(Payment payment) {
		this.payment = payment;
	}

	public Payment getPayment(){
		return payment;
	}

	@Override
	public void doPay() {
		this.payment.doPay();
	}

	@Override
	public String getPay() {
		return payment.getPay();
	}

	@Override
	public void setPay(String pay) {
		this.payment.setPay(pay);
	}
}
