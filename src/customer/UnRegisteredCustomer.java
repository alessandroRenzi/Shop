package customer;

import card.Card;
import card.NoCard;

public class UnRegisteredCustomer extends AbstractCustomer {
	public UnRegisteredCustomer(String nominative, String genre, String birthDay){
		super(nominative,genre,birthDay);
	}

	@Override
	public String addInformation(String result) {
		return "";
	}

	@Override
	public Card myCard() {
		return new NoCard();
	}
}
