package payment;

public class ConcretePayment implements Payment {
	private double totalPrice;
	private String pay;

	public ConcretePayment(double totalPrice) {
		this.totalPrice=totalPrice;
	}

	@Override
	public void doPay() {
		pay = pay + this.totalPrice;
	}

	public String getPay() {
		return pay;
	}
	
	public void setPay(String pay) {
		this.pay = pay;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
}
