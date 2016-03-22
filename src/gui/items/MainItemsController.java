package gui.items;

import java.io.IOException;
import java.util.Iterator;

import cart.Cart;
import cart.ShoppingCart;
import database.Customers;
import gui.MainFX;
import gui.shoppingCart.ShoppingCartController;
import item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import stock.ConcreteStock;

public class MainItemsController {
	@FXML
	private TableColumn<CategoryModelClass, String> categoryColumn;
	@FXML
	private TableView<CategoryModelClass> categoryTable;
	@FXML
	private TableColumn<ItemsModelClass, String> itemsColumn;
	@FXML
	private TableView<ItemsModelClass> itemTable;
	@FXML
	private Label category;
	@FXML
	private Label description;
	@FXML 
	private Label price;
	@FXML
	private Button addToCart;
	@FXML
	private Button showCart;

	private MainFX mainFX;
	private Cart cart;
	private Customers customer = new Customers() ;

	@FXML
	private void initialize() {
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
		showCategoryDetails(null);
		showItemsDetails(null);
		/**
		 * RIVEDERE
		 */
		this.cart = new ShoppingCart(this.customer.getListRegister().get(0));    
		this.categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showCategoryDetails(newValue));
		this.categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showItemColum(newValue));
		this.itemTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showItemsDetails(newValue));

	}

	@FXML
	public void addToCartPressed(ActionEvent event){
		ConcreteStock stock = ConcreteStock.getInstance();
		Iterator<Item> it = stock.getIterator();
		while (it.hasNext()){
			Item temp = it.next();
			if(temp.getDescription().equals(this.description.getText())){
				this.cart.addToCart(temp, 1);
			}
		}
	}

	@FXML
	public void showItemPressed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("shoppingCart/ShoppingCartView.fxml"));
		BorderPane shoppingCart = loader.load();

		ShoppingCartController controller = loader.getController();
		controller.generateShoppingList(this.cart);

		Stage shoppingStage = new Stage();
		shoppingStage.setTitle("Shopping Cart");
		shoppingStage.initModality(Modality.WINDOW_MODAL);
		shoppingStage.initOwner(this.mainFX.getPrimaryStage());
		Scene scene = new Scene(shoppingCart);
		shoppingStage.setScene(scene);
		shoppingStage.showAndWait();	
	}

	public void setMainApp(MainFX mainFX){
		setMainFX(mainFX);
		categoryTable.setItems(mainFX.getObservableListCategory());

	}

	public void showCategoryDetails(CategoryModelClass category){
		if(category != null) {
			this.category.setText(category.getCategory());
		} else {
			this.category.setText("");
		}
	}

	public void showItemsDetails(ItemsModelClass item){
		if(item != null) {
			this.description.setText(item.getDescription());
			this.price.setText(Double.toString(item.getPrice()));
		} else {
			this.description.setText("");
			this.price.setText("");
		}
	}

	public void showItemColum(CategoryModelClass category){
		Iterator<ItemsModelClass> it = this.mainFX.getItemsModelClassIterator();
		ObservableList<ItemsModelClass> obsListTemp = FXCollections.observableArrayList();

		while(it.hasNext()){
			ItemsModelClass itemTemp = it.next();
			if(category.getCategory().equals(itemTemp.getCategory())) {
				obsListTemp.add(itemTemp);
			}
		}
		this.setItemTable(obsListTemp);
	}

	public void setItemTable(ObservableList<ItemsModelClass> obsItemModelClass){
		if(obsItemModelClass.size() != 0) {
			this.itemTable.setItems(obsItemModelClass);
			itemsColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		}
	}

	public MainFX getMainFX() {
		return mainFX;
	}

	private void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;
	}

	public Cart getCart() {
		return cart;
	}
}
