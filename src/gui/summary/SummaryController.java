package gui.summary;

import java.io.IOException;

import gui.MainFX;
import gui.conclusion.ConclusionController;
import gui.customer.CustomerController;
import gui.items.MainItemsController;
import gui.payment.PaymentController;
import gui.shoppingCart.ShoppingCartModelClass;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SummaryController {	
	@FXML
	private TableColumn<ShoppingCartModelClass, String> categoryColumn;
	@FXML
	private Button confirmPayment;
	@FXML
	private Label date;
	@FXML
	private Label deliveryAddress;
	@FXML
	private TableColumn<ShoppingCartModelClass, String>	descriptionColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, String> discountColumn;
	@FXML
	private BorderPane mainLayout;
	@FXML
	private Label name;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> quantityColumn;
	@FXML
	private TableView<ShoppingCartModelClass> shoppingCart;
	@FXML
	private Label totalPrice;
	@FXML
	private Label totalQuantity;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> unitPriceColumn;

	private PaymentController mainPC;
	private ObservableList<ShoppingCartModelClass> shoppingList;
	
	public CustomerController getMainCC() {
		return mainPC.getMainCC();
	} 
	
	public MainItemsController getMainIC() {
		return mainPC.getMainIC();
	}
	
	public void setMainPC(PaymentController mainPC) {
		this.mainPC = mainPC;
	}
	
	public void setPaymentController(PaymentController mainPC) {
		this.setMainPC(mainPC);
		
		this.date.setText(this.mainPC.getMainCC().getCustomer().getBirthDay().toString());
		this.deliveryAddress.setText(this.mainPC.getMainCC().getCustomer().getStreet());
		this.name.setText(this.mainPC.getMainCC().getCustomer().getNominative());

		this.shoppingList = getMainIC().getCartObservableList();
		this.shoppingCart.setItems(this.shoppingList);
		
		this.setTotalPrice(this.getMainIC().getCartTotalPrice());
		this.setTotalQuantity(this.getMainIC().getCart().getQuantityItems());
		
		String strCP = "Pay by " + this.mainPC.getPaymentMethod(); 
		this.confirmPayment.setText(strCP);
	}
	
	public void setTotalPrice(Double total) {
		this.totalPrice.setText(Double.toString(total));
	}

	public void setTotalQuantity(Integer total) {
		this.totalQuantity.setText(Integer.toString(total));
	}
	
	@FXML
	private void initialize(){
		this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
		this.descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		this.discountColumn.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty());
		this.unitPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
	}
	
	@FXML
	public void payEvent(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("view/MainView.fxml"));
		
		this.mainLayout = loader.load();
		Scene scene = new Scene(this.mainLayout);
		
		showConclusionController();

		Stage conclusionStage = new Stage();
		conclusionStage.getIcons().add(new Image("logo_gr.png"));
		conclusionStage.initModality(Modality.WINDOW_MODAL);
		conclusionStage.setTitle("G&R Megastore: conclusion");
		conclusionStage.setScene(scene);
		conclusionStage.showAndWait();
	}

	@FXML
	private void showConclusionController() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("conclusion/ConclusionView.fxml"));

		BorderPane conclusion = loader.load();
		
		ConclusionController controller = loader.getController();
		controller.setSummaryController(this);
		
		this.mainLayout.setCenter(conclusion);
	}
}
