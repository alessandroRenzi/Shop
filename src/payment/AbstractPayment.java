package payment;

public abstract class AbstractPayment implements Payment {
	private Payment payment;

	public AbstractPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public void doPay() {
		this.payment.doPay();
	}
	
	@Override
	public String getPay() {
		return this.payment.getPay();
	}
	
	@Override
	public void setPay(String pay) {
		this.payment.setPay(pay);
	}
	
	public Payment getPayment(){
		return this.payment;
	}

}
