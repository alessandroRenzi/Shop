package payment;

public class BankTransfer extends AbstractPayment {
	public BankTransfer(Payment payment) {
		super(payment);
	}

	@Override
	public void doPay() {
		this.bankTransferPay();
		super.doPay();
	}
	
	public void bankTransferPay() {
		String temp = "Paid by bank transfer: ";
		super.getPayment().setPay(temp);
	
	}
}
