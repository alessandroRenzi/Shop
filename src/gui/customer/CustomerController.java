package gui.customer;

import customer.RegisteredCustomer;
import gui.MainFX;
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
	private TextField birthDay;
	@FXML 
	private RadioButton female;
	@FXML
	private TextField genre;
	@FXML 
	private RadioButton male;
	@FXML 
	private TextField nominative;
	@FXML 
	private TextField street;

	private ShoppingCartController mainSC;
	private RegisteredCustomer customer;

	public RegisteredCustomer getCustomer() {
		return customer;
	}

	private CustomerController getCustomerController() {
		return this;
	}

	public ShoppingCartController getMainSC() {
		return mainSC;
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

	private boolean controlDataAndRegulations() throws Exception {
		if(agreeTerms()) {
			this.customer.setGenre(this.genreCustomer());
			this.customer.setBirthDay(this.birthDay.getText());
			this.customer.setNominative(this.nominative.getText());
			this.customer.setStreet(this.street.getText());
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
			throw new Exception("WARNING: to proceed to payment you must complete the required fields.");
		}

	}

	@FXML
	public void proceedEvent(ActionEvent event) throws Exception {
		boolean result = controlDataAndRegulations();

		if(result == true) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("payment/PaymentView.fxml"));

			BorderPane payment = loader.load();
			Scene scene = new Scene(payment);

			PaymentController controller = loader.getController();
			controller.setCustomerController(this.getCustomerController());

			Stage customerStage = new Stage();
			customerStage.getIcons().add(new Image("logo_gr.png"));
			customerStage.initModality(Modality.WINDOW_MODAL);
			customerStage.setTitle("G&R Megastore: payment");
			customerStage.setScene(scene);
			customerStage.showAndWait();
		} else {
			throw new Exception("WARNING: to proceed to payment you must accept the license terms.");
		}
	}
}
