package gui.shoppingCart;

import gui.items.MainItemsController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	private TableColumn<ShoppingCartModelClass, String>	descriptionColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, String> discountColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> quantityColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, Number> unitPriceColumn;
	@FXML
	private Label totalPrice;
	@FXML
	private Label totalQuantity;
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
	public void trashEvent(ActionEvent event) throws Exception {
		boolean result = false;
		int temp = this.shoppingCart.getSelectionModel().getSelectedIndex();

		double rounding = Math.pow(10,2);
		if(temp < 0) {
			throw new Exception("WARNING: unable to delete item. Unavailable item.");
		} else {
			ShoppingCartModelClass item = this.shoppingCart.getItems().get(temp);

			if(item.getQuantity() > 1) {
				item.setPrice(new SimpleDoubleProperty(Math.round((item.getPrice()-(item.getPrice()/item.getQuantity()))*rounding)/rounding));
				item.setQuantity(new SimpleIntegerProperty(item.getQuantity()-1));
				result = true;
				this.shoppingList.set(temp, item);
			}
		}
		if(!result) {
			this.shoppingList.remove(temp);
		}
		this.removeItemFromCart(temp);
	}

	public void setTotalPrice(Double total) {
		this.totalPrice.setText(Double.toString(total));
	}

	public void setTotalQuantity(Integer total) {
		this.totalQuantity.setText(Integer.toString(total));
	}

	public void removeItemFromCart(int index) {
		this.mainItems.removeFromCart(index);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
		this.setTotalQuantity(this.mainItems.getCart().getQuantityItems());
	}

	public void setMainItemsController(MainItemsController mainItems) {
		this.mainItems = mainItems;
		this.shoppingList = this.mainItems.getObservableListCart();
		this.shoppingCart.setItems(this.shoppingList);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
		this.setTotalQuantity(this.mainItems.getCart().getQuantityItems());
	}
}