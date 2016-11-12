package database;

public class Company {
	private static Company instance = null;

	private String address;
	private String businessName;
	private String contactDetails;
	private String other;

	private Company() {
		this.address = "Viale Giovan Battista Morgagni, 66 - 50134 Firenze (Fi) - Italy";
		this.businessName = "G&R Megastore di Gori M. e Renzi A.";
		this.contactDetails = "Tel: 055.653258 - Fax: 055.653126";
		this.other = "VAT: 00231500246 - E-mail: gerMegastore@gmail.com";
	}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}

	public String getAddress() {
		return address;
	}

	public String getBusinessName() {
		return businessName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public String getOther() {
		return other;
	}

	public void printCompany() {
		System.out.print(this.toString());
	}

	@Override
	public String toString() {
		return getBusinessName() + "\n" + getAddress() + "\n" + getContactDetails() + "\n" + getOther();
	}
}
