package customer;

import java.util.concurrent.atomic.AtomicInteger;

import card.BasicCard;
import card.Card;

public class RegisteredCustomer extends AbstractCustomer {
	private static AtomicInteger counter = new AtomicInteger(0);
	private String genre;
	private String id;
	private String street;

	public RegisteredCustomer(String name, String surname, String birthDay, String genre, String street){
		super(name,surname,birthDay);
		this.genre = genre;
		this.id = "CST" + counter.incrementAndGet();
		this.street = street;
	}

	public String getGenre(){
		return this.genre;
	}

	public String getId() {
		return this.id;
	}

	public String getStreet(){
		return this.street;
	}

	@Override
	public String addInformation(String result) {
		return result = " - Genre: " + getGenre() + " - Street: " + getStreet() + " - Id: " + getId();
	}

	@Override
	public Card myCard() {
		return new BasicCard();
	}

	public void resetId() {
		counter.set(0);
	}
}
