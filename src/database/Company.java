package database;

public class Company {
	private String address;
	private String businessName;
	private String contactDetails;
	private String other;

	public Company() {
		this.address = "Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy";
		this.businessName = "G&R Megastore di Gori M. e Renzi A.";
		this.contactDetails = "Tel: 055.653258 - Fax: 055.653126";
		this.other = "VAT: 00231500246 - E-mail: gerMegastore@gmail.com";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public void printCompany() {
		System.out.print(this.toString());
	}

	@Override
	public String toString() {
		return getBusinessName() + "\n" + getAddress() + "\n" + getContactDetails() + "\n" + getOther();
	}
}
