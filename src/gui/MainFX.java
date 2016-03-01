package gui;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import category.Category;
import database.Categories;
import database.Items;
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


public class MainFX extends Application {
	private Stage primaryStage;
	private BorderPane mainLayout;
	private ObservableList<CategoryModelClass> observableListCategory = FXCollections.observableArrayList();
	private ObservableList<ItemsModelClass> observableListItems = FXCollections.observableArrayList();
	private Items items = new Items();
	private Categories categories = new Categories();

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.generateCategoryObservList(categories.getListCategories());
		this.generateItemsObservList(items.getListItems());
		this.primaryStage = primaryStage;

		primaryStage.getIcons().add(new Image("http://www.helisaaugusto.com.br/site/2011/imagens/logo_gr.png"));
		primaryStage.setTitle("G&R Megastore");
		showMainView();
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
		controller.setMain(this);

		this.mainLayout.setCenter(mainItems);
	}


	public void generateCategoryObservList(List<Category> list){
		Iterator<Category> iterator = createIteratorCategories(list);

		while(iterator.hasNext()) {
			if(!observableListCategory.contains(iterator.next())) {
				observableListCategory.add(new CategoryModelClass(iterator.next()));
			}
		}
	}

	public void generateItemsObservList(List<Item> list){
		Iterator<Item> iterator = createIteratorItems(list);

		while(iterator.hasNext()) {
			observableListItems.add(new ItemsModelClass(iterator.next()));
		}
	}

	public Iterator<Category> createIteratorCategories(List<Category> list) {
		return list.iterator();
	}

	public Iterator<Item> createIteratorItems(List<Item> list) {
		return list.iterator();
	}

	public ObservableList<CategoryModelClass> getObservableListCategory() {
		return observableListCategory;
	}

	public ObservableList<ItemsModelClass> getObservableListItems() {
		return observableListItems;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}	
}
