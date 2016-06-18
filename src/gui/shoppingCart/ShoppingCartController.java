package gui.shoppingCart;

import gui.MainFX;
import gui.items.MainItemsController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShoppingCartController {
	@FXML
	private TableColumn<ShoppingCartModelClass, String> categoryColumn;
	@FXML 
	private Button deleteButton;
	@FXML
	private TableColumn<ShoppingCartModelClass, String>	descriptionColumn;
	@FXML
	private TableColumn<ShoppingCartModelClass, String> discountColumn;
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

	private MainItemsController mainItems;
	private ObservableList<ShoppingCartModelClass> shoppingList;

	public void setMainItemsController(MainItemsController mainItems) {
		this.mainItems = mainItems;
		this.shoppingList = this.mainItems.getCartObservableList();
		this.shoppingCart.setItems(this.shoppingList);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
		this.setTotalQuantity(this.mainItems.getCart().getQuantityItems());
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
		this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty());
		this.unitPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
		this.discountColumn.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
	}

	public void removeItemFromCart(int index) {
		this.mainItems.removeFromCart(index);
		this.setTotalPrice(this.mainItems.getCartTotalPrice());
		this.setTotalQuantity(this.mainItems.getCart().getQuantityItems());
	}

	private double roundPrice(ShoppingCartModelClass item) {
		double price = item.getPrice();
		int quantity = item.getQuantity();
		double rounding = Math.pow(10,2);

		return Math.round((price-(price/quantity))*rounding)/rounding;
	}

	@FXML
	public void proceedEvent(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("payment/PaymentView.fxml"));
		
		
	}

	@FXML
	public void removeEvent(ActionEvent event) throws Exception {
		boolean result = false;
		int temp = this.shoppingCart.getSelectionModel().getSelectedIndex();

		if(temp < 0) {
			throw new Exception("WARNING: unable to delete item. Unavailable item.");
		} else {
			ShoppingCartModelClass item = this.shoppingCart.getItems().get(temp);

			if(item.getQuantity() > 1) {
				item.setPrice(new SimpleDoubleProperty(roundPrice(item)));
				item.setQuantity(new SimpleIntegerProperty(item.getQuantity()-1));
				this.shoppingList.set(temp, item);
				result = true;
			}
		}
		if(!result) {
			this.shoppingList.remove(temp);
		}
		this.removeItemFromCart(temp);
	}
}