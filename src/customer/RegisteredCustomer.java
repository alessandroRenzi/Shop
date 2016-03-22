package customer;

import java.util.concurrent.atomic.AtomicInteger;

import card.BasicCard;
import card.Card;

public class RegisteredCustomer extends AbstractCustomer {
	private static AtomicInteger counter = new AtomicInteger(0);
	private String id;
	private String street;

	public RegisteredCustomer(String nominative, String genre, String birthDay, String street){
		super(nominative,genre,birthDay);
		this.id = "CST" + counter.incrementAndGet();
		this.street = street;
	}

	public String getId() {
		return this.id;
	}

	public String getStreet(){
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String addInformation(String result) {
		return result = " | Street: " + getStreet() + " | Id: " + getId();
	}

	@Override
	public Card myCard() {
		return new BasicCard();
	}

	public void resetId() {
		counter.set(0);
	}
}
