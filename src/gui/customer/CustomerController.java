package gui.customer;

import java.io.IOException;

import customer.RegisteredCustomer;
import gui.MainFX;
import gui.items.MainItemsController;
import gui.payment.PaymentController;
import gui.shoppingCart.ShoppingCartController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerController {
	@FXML 
	private CheckBox agreeTerms;
	@FXML 
	private TextField city;
	@FXML 
	private TextField country;
	@FXML
	private TextField dateBirth;
	@FXML 
	private TextField deliveryAddress;
	@FXML 
	private RadioButton female;
	@FXML
	private BorderPane mainLayout;
	@FXML 
	private RadioButton male;
	@FXML 
	private TextField name;
	@FXML 
	private TextField postalCod;
	@FXML 
	private TextField stPrReg;
	@FXML 
	private TextField surname;

	private RegisteredCustomer customer;
	private ShoppingCartController mainSC;

	public RegisteredCustomer getCustomer() {
		return customer;
	}

	public MainItemsController getMainIC() {
		return mainSC.getMainIC();
	}
	
	public ShoppingCartController getMainSC() {
		return mainSC;
	}
	
	public String getName() {
		return name.getText();
	}

	public void setMainSC(ShoppingCartController mainSC) {
		this.mainSC = mainSC;
	}

	public void setShoppingCartController(ShoppingCartController mainSC) {
		this.setMainSC(mainSC);
		this.customer = this.mainSC.getCustomer();
	}

	@FXML
	private boolean agreeTerms() {
		if(this.agreeTerms.isSelected()) {
			return true;
		}
		return false;
	}

	@FXML
	private boolean controlDataAndRegulations() throws Exception {
		if(agreeTerms()) {
			this.customer.setBirthDay(this.dateBirth.getText());
			this.customer.setGenre(this.genreCustomer());
			this.customer.setNominative(this.nominativeCustomer());
			this.customer.setStreet(this.streetCustomer());
			return true;
		}
		return false;
	}

	@FXML
	private String genreCustomer() throws Exception {
		if(this.male.isSelected()) {
			return "Male";
		} else if(this.female.isSelected()) {
			return "Female";
		} else {
			throw new Exception("WARNING: to proceed to payment you must select a genre.");
		}
	}
	
	@FXML
	private String nominativeCustomer() throws Exception {
		String name = this.name.getText();
		String surname = this.surname.getText();
		
		if(name != "" && surname != "") {
			String nominative = name + " " + surname;
			return nominative;
		} else {
			throw new Exception("WARNING: to proceed to payment 'Name' and/or 'Surname' field can not be empty.");
		}
	}

	@FXML
	public void proceedEvent(ActionEvent event) throws Exception {
		boolean result = controlDataAndRegulations();

		if(result == true) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("view/MainView.fxml"));
			
			this.mainLayout = loader.load();
			Scene scene = new Scene(this.mainLayout);
			
			showPaymentController();

			Stage paymentStage = new Stage();
			paymentStage.getIcons().add(new Image("logo_gr.png"));
			paymentStage.initModality(Modality.WINDOW_MODAL);
			paymentStage.setTitle("G&R Megastore: payment");
			paymentStage.setScene(scene);
			paymentStage.showAndWait();
		} else {
			throw new Exception("WARNING: to proceed to payment you must accept the license terms.");
		}
	}
	
	@FXML
	private void showPaymentController() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("payment/PaymentView.fxml"));

		BorderPane payment = loader.load();

		PaymentController controller = loader.getController();
		controller.setCustomerController(this);
		
		this.mainLayout.setCenter(payment);
	}

	@FXML
	private String streetCustomer() throws Exception {
		String deliveryAddress = this.deliveryAddress.getText();
		String city = this.city.getText();
		String country = this.country.getText();
		String postalCode = this.postalCod.getText();
		String stPrReg = this.stPrReg.getText();
		
		if(city != "" && country != "" && postalCode != "" && stPrReg != "") {
			String street = deliveryAddress + " - " + city + " (" + stPrReg + ") - " + postalCode + " - " + country;
			return street;
		} else {
			throw new Exception("WARNING: to proceed to payment 'Delivery address', 'City', 'Country', 'Postal code' and/or "
					+ "'State/Province or Region' field can not be empty.");
		}
	}
}
