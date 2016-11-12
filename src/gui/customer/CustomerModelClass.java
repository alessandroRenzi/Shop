package gui.customer;

import customer.RegisteredCustomer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerModelClass {
	private StringProperty birthDay;
	private StringProperty genre;
	private StringProperty id;
	private StringProperty nominative;
	private StringProperty street;

	public CustomerModelClass(RegisteredCustomer customer) {
		this.birthDay = new SimpleStringProperty(customer.getBirthDay().toString());
		this.genre = new SimpleStringProperty(customer.getGenre());
		this.id = new SimpleStringProperty(customer.getId());
		this.nominative = new SimpleStringProperty(customer.getNominative());
		this.street = new SimpleStringProperty(customer.getStreet()); 
	}

	public String getBirthDay() {
		return this.birthDay.get();
	}

	public String getGenre() {
		return this.genre.get();
	}

	public String getId() {
		return this.id.get();
	}

	public String getNominative() {
		return this.nominative.get();
	}

	public String getStreet() {
		return this.street.get();
	}

	public void setBirthDay(String birthDay){
		this.birthDay.set(birthDay);
	}

	public void setGenre(String genre) {
		this.genre.set(genre);
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public void setNominative(String nominative){
		this.nominative.set(nominative);
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty getBirthDayProperty() {
		return this.birthDay;
	}

	public StringProperty getGenreProperty() {
		return genre;
	}

	public StringProperty getIdProperty() {
		return id;
	}

	public StringProperty getNominativeProperty() {
		return nominative;
	}

	public StringProperty getStreetProperty() {
		return street;
	}

	public void setBirthDay(StringProperty birthDay) {
		this.birthDay = birthDay;
	}

	public void setGenre(StringProperty genre) {
		this.genre = genre;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public void setNominative(StringProperty nominative) {
		this.nominative = nominative;
	}

	public void setStreet(StringProperty street) {
		this.street = street;
	}
}
