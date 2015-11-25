package payment;

public class ConcretePayment implements Payment {
	private double totalPrice;

	public ConcretePayment(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public void doPay() {
		System.out.print(this.totalPrice);
	}
}
