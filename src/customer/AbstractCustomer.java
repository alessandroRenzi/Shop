package customer;

import java.time.LocalDate;

import card.Card;

public abstract class AbstractCustomer implements Customer{
	private String name,surname;
	private LocalDate birthDay;
	private int age;
	private Card card;

		public AbstractCustomer(String name, String surname, String birthDay){
			this.name = name;
			this.surname = surname;
			this.birthDay = LocalDate.parse(birthDay);
			ageEvaluator();
			this.assignCard();
		}

		public void assignCard(){
		this.card = myCard();
		}
		
		public Card getCard(){
			return this.card;
		}
		
		@Override
		public String getName() {
		return name;
		}

		@Override
		public String getSurname() {
			return surname;
		}

		@Override
		public int getAge() {
			return this.age;
		}

		private void ageEvaluator() {
			LocalDate temp = LocalDate.now();
			int tempAge = temp.getYear()- birthDay.getYear();
			this.age = tempAge;
		}

		public  String toString(){
			String result = "Name: " + getName() + " Surname: " + getSurname() + " Age: " + getAge();
			result = result + addInformation(result);
			return result;
		}
		
		public abstract String addInformation(String result);
		
		public abstract Card myCard();

}
