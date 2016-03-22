	package gui;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import category.Category;
import gui.items.CategoryModelClass;
import gui.items.ItemsModelClass;
import gui.items.MainItemsController;
import gui.view.MainViewController;
import item.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stock.ConcreteStock;
import stock.Stock;

public class MainFX extends Application {
	private BorderPane mainLayout;
	private ObservableList<CategoryModelClass> observableListCategory = FXCollections.observableArrayList();
	private ObservableList<ItemsModelClass> observableListItems = FXCollections.observableArrayList();
	private Stage primaryStage;
	private Stock stock = ConcreteStock.getInstance();

	public ObservableList<CategoryModelClass> getObservableListCategory() {
		return observableListCategory;
	}

	public ObservableList<ItemsModelClass> getObservableListItems() {
		return observableListItems;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public BorderPane getMainLayout() {
		return mainLayout;
	}

	public Stock getStock() {
		return stock;
	}

	public Iterator<Category> createIteratorCategory(List<Category> list) {
		return list.iterator();
	}

	public Iterator<Item> createIteratorItems(List<Item> list) {
		return list.iterator();
	}
	
	public Iterator<CategoryModelClass> getCategoryModelClassIterator(){
		return this.observableListCategory.iterator();
	}
	
	public Iterator<ItemsModelClass> getItemsModelClassIterator(){
		return this.observableListItems.iterator();
	}

	public void generateCategoryObservList(List<Category> list){
		Iterator<Category> iterator = createIteratorCategory(removeDuplicate(list));

		while(iterator.hasNext()) {
			observableListCategory.add(new CategoryModelClass(iterator.next()));
		}
	}

	public void generateItemsObservList(List<Item> list){
		Iterator<Item> iterator = createIteratorItems(list);

		while(iterator.hasNext()) {
			observableListItems.add(new ItemsModelClass(iterator.next()));
		}
	}


	private List<Category> removeDuplicate(List<Category> list) {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).equals(list.get(i+1))) {
				list.remove(i);
				i--;
			}
		}
		return list; 
	}	

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();

		MainViewController controller = loader.getController();
		controller.setMainApp(this);

		showMainItems();

		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showMainItems() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("items/MainItems.fxml"));
		BorderPane mainItems = loader.load();

		MainItemsController controller = loader.getController();
		controller.setMainApp(this);

		this.mainLayout.setCenter(mainItems);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		stock.initialize();
		generateCategoryObservList(stock.getCategories());
		generateItemsObservList(stock.getItems());

		this.primaryStage = primaryStage;
		primaryStage.getIcons().add(new Image("http://www.helisaaugusto.com.br/site/2011/imagens/logo_gr.png"));
		primaryStage.setTitle("G&R Megastore");
		showMainView();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
