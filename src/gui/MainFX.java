package gui;

import java.io.IOException;
import java.util.Iterator;

import database.Items;
import gui.items.ItemsModelClass;
import gui.items.MainItemsController;
import gui.view.MainViewController;
import item.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainFX extends Application {
	private Stage primaryStage;
	private BorderPane mainLayout;
	private ObservableList<ItemsModelClass> observableList = FXCollections.observableArrayList();
	private Items items = new Items();

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.generateItemsObservList();
		this.primaryStage = primaryStage;
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


	public void generateItemsObservList(){
		Iterator<Item> iteratorItems = items.getIterator();

		while(iteratorItems.hasNext()) {
			if(!observableList.contains(iteratorItems.next().getCategory())) {
				observableList.add(new ItemsModelClass(iteratorItems.next()));
			}
		}
	}

	public ObservableList<ItemsModelClass> getObservableList() {
		return observableList;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}	
}
