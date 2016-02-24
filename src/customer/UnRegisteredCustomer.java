package customer;

import card.Card;
import card.NoCard;

public class UnRegisteredCustomer extends AbstractCustomer {

	public UnRegisteredCustomer(String name, String surname, String birthDay){
		super(name,surname,birthDay);
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
