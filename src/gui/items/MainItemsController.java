package gui.items;

import java.io.IOException;
import java.util.Iterator;

import cart.Cart;
import cart.ShoppingCart;
import customer.AbstractCustomer;
import customer.RegisteredCustomer;
import gui.MainFX;
import gui.shoppingCart.ShoppingCartController;
import gui.shoppingCart.ShoppingCartModelClass;
import item.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.image.Image;
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

	private ObservableList<ShoppingCartModelClass> cartObservableList = FXCollections.observableArrayList();
	private MainFX mainFX;
	private Cart cart;
	private AbstractCustomer customer = new RegisteredCustomer("name","male","1960-05-10","street");

	private static final double ROUNDING = Math.pow(10,2);

	@FXML
	private void initialize() {
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
		showCategoryDetails(null);
		showItemsDetails(null);
		/**
		 * RIVEDERE
		 */
		this.cart = new ShoppingCart(this.customer);    
		this.categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showCategoryDetails(newValue));
		this.categoryTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showItemColum(newValue));
		this.itemTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showItemsDetails(newValue));
	}

	@FXML
	public void addToCartPressed(ActionEvent event) {
		ConcreteStock stock = ConcreteStock.getInstance();
		Iterator<Item> iteratorStock = stock.getIterator();

		while(iteratorStock.hasNext()){
			Item item = iteratorStock.next();

			if(item.getDescription().equals(this.description.getText())) {
				this.cart.addToCart(item, 1);

				boolean result = itemPresenceControl(cart, item, 0);
				if(result == false) { 
					this.cartObservableList.add(new ShoppingCartModelClass(item, this.cart));
				}
			}
		}
	}

	private boolean itemPresenceControl(Cart cart, Item item, int id) {
		Iterator<ShoppingCartModelClass> iteratorCart = getObservableListCart().iterator();
		boolean result = false;

		while(iteratorCart.hasNext()) {
			int count = 0;
			ShoppingCartModelClass currentItem = iteratorCart.next();

			if(item.getDescription().equals(currentItem.getDescription()) && id == 0) {
				currentItem.setQuantity(new SimpleIntegerProperty(currentItem.getQuantity()+1));
				currentItem.setPrice(new SimpleDoubleProperty(Math.round((currentItem.getPrice()+item.getPrice())*ROUNDING)/ROUNDING));
				result = true;
			} else if (item.getDescription().equals(currentItem.getDescription()) && id == 1 && count != 0){
				count++;
				currentItem.setQuantity(new SimpleIntegerProperty(currentItem.getQuantity()-1));
				currentItem.setPrice(new SimpleDoubleProperty(Math.round((currentItem.getPrice()-item.getPrice())*ROUNDING)/ROUNDING));
				result = true;
			}
		}
		return result;
	}

	@FXML
	public void showItemPressed(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("shoppingCart/ShoppingCartView.fxml"));
		
		BorderPane shoppingCart = loader.load();
		Scene scene = new Scene(shoppingCart);

		ShoppingCartController controller = loader.getController();
		controller.setMainItemsController(this);

		Stage shoppingStage = new Stage();
		shoppingStage.getIcons().add(new Image("logo_gr.png"));
		shoppingStage.initModality(Modality.WINDOW_MODAL);
		shoppingStage.initOwner(this.mainFX.getPrimaryStage());
		shoppingStage.setTitle("G&R Megastore: cart");
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

	public void showItemColum(CategoryModelClass category) {
		Iterator<ItemsModelClass> it = this.mainFX.getItemsModelClassIterator();
		ObservableList<ItemsModelClass> obsListTemp = FXCollections.observableArrayList();

		while(it.hasNext()) {
			ItemsModelClass itemTemp = it.next();
			if(category.getCategory().equals(itemTemp.getCategory())) {
				obsListTemp.add(itemTemp);
			}
		}
		this.setItemTable(obsListTemp);
	}

	public void setItemTable(ObservableList<ItemsModelClass> obsItemModelClass) {
		if(obsItemModelClass.size() != 0) {
			this.itemTable.setItems(obsItemModelClass);
			itemsColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		}
	}

	public double getCartTotalPrice() {
		return Math.round((this.cart.getTotalPrice())*ROUNDING)/ROUNDING;
	}

	public void removeFromCart(int index) {
		Iterator<Item> iteratorItem = getCart().getItemIterator();

		while(iteratorItem.hasNext()){
			Item item = iteratorItem.next();

			if(item.getDescription().equals(cart.getCart().get(index).getDescription())) {
				this.cart.removeFromCart(item, 1);

				boolean result = itemPresenceControl(cart, item, 1);
				if(result == false) { 
					this.cartObservableList.remove(new ShoppingCartModelClass(item, this.cart));
				}
			}
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

	public ObservableList<ShoppingCartModelClass> getObservableListCart() {
		return this.cartObservableList;
	}
}
