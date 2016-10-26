package transaction;

import payment.Payment;

public abstract class AbsTransaction implements Transaction{
	private Payment payment;
	private String transaction;
	
	public AbsTransaction(Payment payment){
		this.payment = payment;
	}
	
	@Override
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public void salesTransaction() {
		this.payment.doPay();
		this.transaction= this.payment.getPay();
	}

	public String getTransaction() {
		return transaction;
	}

	
}
