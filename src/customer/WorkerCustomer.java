package customer;

import card.Card;
import card.GoldCard;

public class WorkerCustomer extends AbstractCustomer {
	private String street;
	private String workingArea;

	public WorkerCustomer(String nominative, String genre, String birthDay, String street, String workingArea){
		super(nominative,genre,birthDay);
		this.street = street;
		this.workingArea = workingArea;
	}

	public String getStreet(){
		return this.street;
	}

	public String getWorkingArea(){
		return this.workingArea;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setWorkingArea(String workingArea) {
		this.workingArea = workingArea;
	}

	@Override
	public String addInformation(String result) {
		return result = " | Street: " + getStreet() + " | WorkingArea: " + getWorkingArea();
	}

	@Override
	public Card myCard() {
		return new GoldCard();
	}
}
