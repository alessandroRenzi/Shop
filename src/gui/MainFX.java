package gui;

import java.io.IOException;
import java.util.Iterator;

import database.Items;
import gui.items.ItemsModelClass;
import gui.items.MainItemsController;
import item.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainFX extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private ObservableList<ItemsModelClass> observableList = FXCollections.observableArrayList();
	private Items items = new Items();

	public MainFX() {
		Iterator<Item> iteratorItems = items.getIterator();
		while (iteratorItems.hasNext()) {
			observableList.add(new ItemsModelClass(iteratorItems.next()));
		}
	}
	
	public ObservableList<ItemsModelClass> getObservableList() {
		return observableList;
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		MainFX.primaryStage = primaryStage;
		primaryStage.setTitle("G&R Megastore");
		showMainView();
	}

	private static void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		
		loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("items/MainItems.fxml"));
		BorderPane mainAbout = loader.load();
		
		MainItemsController mainItemsController = new MainItemsController();
		
		mainLayout.getChildren().add(mainAbout);
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showMainAbout() throws IOException  {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("about/MainAbout.fxml"));
		AnchorPane mainAbout = loader.load();

		Stage addMainAbout = new Stage();
		addMainAbout.setTitle("About G&R");
		addMainAbout.initModality(Modality.WINDOW_MODAL);
		addMainAbout.initOwner(primaryStage);

		Scene scene = new Scene(mainAbout);
		addMainAbout.setScene(scene);
		addMainAbout.showAndWait();
	}
	
	public void showMainItemsController() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("items/MainItems.fxml"));
		BorderPane mainAbout = loader.load();

		MainItemsController mainItemsController = loader.getController();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
