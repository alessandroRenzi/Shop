package gui.shoppingCart;


import gui.items.MainItemsController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ShoppingCartController {
	
	@FXML
	private TableView<ShoppingCartModelClass> shoppingCart;
	@FXML
	private TableColumn<ShoppingCartModelClass, String> categoryColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass,String>	descriptionColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, String> discountColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> quantityColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> unitPriceColumn;
	@FXML
	private Label totalPrice;
	@FXML 
	private Button deleteButton;
	
	private ObservableList<ShoppingCartModelClass> shoppingList;

	
	private MainItemsController mainItems;

	
	@FXML
	public void initialize(){
		this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
		this.descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty());
		this.unitPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
		this.discountColumn.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
	}
	
	@FXML
	public void trashEvent(ActionEvent event){
		int temp = this.shoppingCart.getSelectionModel().getSelectedIndex();
		if(temp>=0){
			this.shoppingList.remove(temp);
			this.removeItemFromCart(temp);
		}
		
	}

	public void setTotalPrice(Double total){
		this.totalPrice.setText(Double.toString(total));
	}
	
	public void removeItemFromCart(int index){
		this.mainItems.removeFromCart(index);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
	}
	
	public void setMainItemsController(MainItemsController mainItems){
		this.mainItems = mainItems;
		this.shoppingList = this.mainItems.getObservableListCart();
		this.shoppingCart.setItems(this.shoppingList);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
	}
}


