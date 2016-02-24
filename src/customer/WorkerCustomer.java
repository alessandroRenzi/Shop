package customer;

import card.Card;
import card.GoldCard;

public class WorkerCustomer extends AbstractCustomer {
	private String genre;
	private String street;
	private String workingArea;

	public WorkerCustomer(String name, String surname, String birthDay, String genre, String street, String workingArea){
		super(name,surname,birthDay);
		this.genre = genre;
		this.street = street;
		this.workingArea = workingArea;
	}

	public String getGenre(){
		return this.genre;
	}

	public String getStreet(){
		return this.street;
	}

	public String getWorkingArea(){
		return this.workingArea;
	}

	@Override
	public String addInformation(String result) {
		return result = " - Genre: " + getGenre() + " - Street: " + getStreet() + " - WorkingArea: " + getWorkingArea();
	}

	@Override
	public Card myCard() {
		return new GoldCard();
	}
}
