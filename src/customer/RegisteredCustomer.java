package customer;

import java.util.concurrent.atomic.AtomicInteger;

import card.BasicCard;
import card.Card;

public class RegisteredCustomer extends AbstractCustomer {
	private String genre, street,id;
	private static AtomicInteger counter = new AtomicInteger(0);

		public RegisteredCustomer(String name, String surname, String birthDay,String genre, String street){
			super(name,surname,birthDay);
			this.genre = genre;
			this.street = street;
			this.id = "CST" + counter.incrementAndGet();
		}

		public String getGenre(){
			return this.genre;
		}
		
		public String getStreet(){
			return this.street;
		}
		
		public String getiD() {
			return this.id;
		}
		
		public void resetID() {
			counter.set(0);
		}

		@Override
		public String addInformation(String result) {
			return result =" Genre: "+ getGenre() + " Street: " + getStreet() + " Id: "+ getiD();
			
		}

		@Override
		public Card myCard() {
			return new BasicCard();
		}
}
