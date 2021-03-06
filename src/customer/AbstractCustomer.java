package customer;

import java.time.LocalDate;

import card.Card;

public abstract class AbstractCustomer implements Customer{
	private int age;
	private LocalDate birthDay;
	private Card card;
	private String nominative;
	private String genre;

	public AbstractCustomer(String nominative, String genre, String birthDay){
		this.birthDay = LocalDate.parse(birthDay);
		this.ageEvaluator();
		this.assignCard();
		this.nominative = nominative;
		this.genre = genre;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public LocalDate getBirthDay() {
		return birthDay;
	}

	public Card getCard(){
		return card;
	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public String getNominative() {
		return nominative;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse(birthDay);
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setNominative(String nominative) {
		this.nominative = nominative;
	}

	private void ageEvaluator() {
		LocalDate temp = LocalDate.now();
		int tempAge = temp.getYear()-birthDay.getYear();
		this.age = tempAge;
	}

	public void assignCard(){
		this.card = myCard();
	}

	@Override
	public  String toString(){
		String result = "Nominative: " + getNominative() + " | Genre: " + getGenre() + " | Age: " + getAge();
		result = result+addInformation(result);
		return result;
	}

	abstract String addInformation(String result);
	abstract Card myCard();
}
