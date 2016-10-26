package gui.payment;

import java.io.IOException;
import java.time.Year;

import gui.MainFX;
import gui.customer.CustomerController;
import gui.items.MainItemsController;
import gui.summary.SummaryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PaymentController {
	final static String CC = "Credit Card";
	final static String EY = "expiration year";
	final static String EM = "expiration month";
	final static String HN = "holder's name";
	final static String N = "number";
	final static String PP = "PayPal";
	
	@FXML
	private RadioButton acceptCredCard;
	@FXML
	private RadioButton acceptPayPal;
	@FXML
	private TextField creditCardNumber;
	@FXML
	private TextField creditCardHoldersName;
	@FXML
	private TextField creditCardExpirationMonth;
	@FXML
	private TextField creditCardExpirationYear;
	@FXML
	private BorderPane mainLayout;
	@FXML
	private Label nominative;
	@FXML
	private TextField payPalNumber;
	@FXML
	private TextField payPalHoldersName;
	@FXML
	private TextField payPalExpirationMonth;
	@FXML
	private TextField payPalExpirationYear;
	@FXML
	private Button proceedButton;
	
	private CustomerController mainCC;
	private String paymentMethod;

	public CustomerController getMainCC() {
		return mainCC;
	}
	
	public MainItemsController getMainIC() {
		return mainCC.getMainIC();
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setCustomerController(CustomerController mainCC) {
		this.setMainCC(mainCC);
		fillNameFields(this.mainCC);
	}
	
	public void setMainCC(CustomerController mainCC) {
		this.mainCC = mainCC;
	}
	
	private void controlAssistant(String card, String eY, String eM, String hN, String n) throws Exception {
		controlContentsAndCompleteness(card, n, N, 10);
		
		if(hN.length() != 0) {
			for(int i = 0; i < hN.length(); i++) {
				if(controlHolderName(hN, i) == false) {
					throw new Exception("WARNING: " + card + " holder's name must contain only characters.");
				}
			}
		} else {
			throw new Exception("WARNING: " + card + " holder's name can not be empty.");
		}
		
		controlContentsAndCompleteness(card, eM, EM, 2);
		
		controlContentsAndCompleteness(card, eY, EY, 4);
		if(Integer.parseInt(eY) < Year.now().getValue()) {
			throw new Exception("WARNING: " + card + " expiration year must be greater than or equal to the current year.");
		}
	}
	
	private void controlContentsAndCompleteness(String card, String str, String component, int length) throws Exception {
		if(str.length() == length) {
			if(str.length() != 0) {
				try {
					Integer.parseInt(str);
				} catch(NumberFormatException e) {
					throw new Exception("WARNING: " + card + " " + component + " must contain only numbers.");
				}
			} else {
				throw new Exception("WARNING: " + card + " " + component + " can not be empty.");
			}
		} else {
			throw new Exception("WARNING: " + card + " " + component + " must be " + length + " characters long.");
		}
	}

	private void controlDataEntered() throws Exception {
		if(this.paymentMethod == CC) {
			String eY = this.creditCardExpirationYear.getText();
			String eM = this.creditCardExpirationMonth.getText();
			String hN = this.creditCardHoldersName.getText();
			String n = this.creditCardNumber.getText();

			controlAssistant(CC, eY, eM, hN, n);
		} else {
			String eY = this.payPalExpirationYear.getText();
			String eM = this.payPalExpirationMonth.getText();
			String hN = this.payPalHoldersName.getText();
			String n = this.payPalNumber.getText();
		
			controlAssistant(PP, eY, eM, hN, n);
		}
	}
	
	private boolean controlHolderName(String hN, int i) {
		boolean result = false;
		
		if(hN.charAt(i) >= 'a' || hN.charAt(i) >= 'A' || hN.charAt(i) == ' ') {
			result = true;
		}
		return result;
	}	

	private void fillNameFields(CustomerController mainCC) {
		String newNominative = mainCC.getName() + ",";
		this.nominative.setText(newNominative);
	}
	
	@FXML
	public void proceedEvent(ActionEvent event) throws Exception {
		controlDataEntered();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("view/MainView.fxml"));
		
		this.mainLayout = loader.load();
		Scene scene = new Scene(this.mainLayout);
		
		showSummaryController();

		Stage summaryStage = new Stage();
		summaryStage.getIcons().add(new Image("logo_gr.png"));
		summaryStage.initModality(Modality.WINDOW_MODAL);
		summaryStage.setTitle("G&R Megastore: summary");
		summaryStage.setScene(scene);
		summaryStage.showAndWait();
	}

	@FXML
	private void selectPaymentMethod(ActionEvent event) throws Exception {
		if(this.acceptCredCard.isSelected()) {
			this.paymentMethod = CC;
		} else if(this.acceptPayPal.isSelected()) {
			this.paymentMethod = PP;
		} else {
			throw new Exception("WARNING: to proceed to payment you must select a payment method.");
		}
	}
	
	@FXML
	private void showSummaryController() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("summary/SummaryView.fxml"));

		BorderPane summary = loader.load();
		
		SummaryController controller = loader.getController();
		controller.setPaymentController(this);
		
		this.mainLayout.setCenter(summary);
	}
}
