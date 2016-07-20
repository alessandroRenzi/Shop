package gui.payment;

import customer.RegisteredCustomer;
import gui.customer.CustomerController;
import gui.customer.CustomerModelClass;

public class PaymentController {
	private RegisteredCustomer customer;
	private CustomerModelClass customerMC;
	private CustomerController mainCC;

	public CustomerController getMainCC() {
		return mainCC;
	}

	public void setCustomerController(CustomerController mainCC) {
		this.setMainCC(mainCC);
		this.customer = this.mainCC.getCustomer();
		this.customerMC = new CustomerModelClass(customer);
	}

	public void setMainCC(CustomerController mainCC) {
		this.mainCC = mainCC;
	}

	public CustomerModelClass getCustomer() {
		return customerMC;
	}

	public void setCustomer(CustomerModelClass customer) {
		this.customerMC = customer;
	}
}
