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
		System.out.print("Paid by bank transfer: ");
	}
}
