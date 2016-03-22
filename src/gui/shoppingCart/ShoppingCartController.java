package gui.shoppingCart;

import java.util.Iterator;

import cart.Cart;
import item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

	private ObservableList<ShoppingCartModelClass> shoppingList = FXCollections.observableArrayList();

	@FXML
	public void initialize(){
		this.shoppingCart.setItems(this.shoppingList);
		this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
		this.descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty());
		this.unitPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
		this.discountColumn.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
	}

	public void generateShoppingList(Cart cart){
		this.totalPrice.setText(Double.toString(cart.getTotalPrice()));
		Iterator<Item> shoppingList = cart.getItemIterator();
		while (shoppingList.hasNext()){
			this.shoppingList.add(new ShoppingCartModelClass(shoppingList.next(),cart));
		}
	}
}


