package customer;

import java.time.LocalDate;

import card.Card;

public abstract class AbstractCustomer implements Customer{
	private int age;
	private LocalDate birthDay;
	private Card card;
	private String name;
	private String surname;

	public AbstractCustomer(String name, String surname, String birthDay){
		this.birthDay = LocalDate.parse(birthDay);
		ageEvaluator();
		this.assignCard();
		this.name = name;
		this.surname = surname;
	}

	public Card getCard(){
		return card;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSurname() {
		return surname;
	}

	private void ageEvaluator() {
		LocalDate temp = LocalDate.now();
		int tempAge = temp.getYear() - birthDay.getYear();
		this.age = tempAge;
	}

	public void assignCard(){
		this.card = myCard();
	}

	public  String toString(){
		String result = "Name: " + getName() + " | Surname: " + getSurname() + " | Age: " + getAge();
		result = result+addInformation(result);
		return result;
	}

	abstract String addInformation(String result);
	abstract Card myCard();
}
