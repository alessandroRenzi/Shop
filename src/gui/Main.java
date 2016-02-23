package gui;

import java.io.IOException;
import java.util.Iterator;

import database.Items;
import gui.view.ConcreteItemProperty;
import gui.view.HomePageController;
import item.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<ConcreteItemProperty> itemData = FXCollections.observableArrayList();
	private Items items = new Items();

	public Main() {
		Iterator<Item> it = getIterator();
		while (it.hasNext()) {
			itemData.add(new ConcreteItemProperty(it.next()));
		}
	}

	public Iterator<Item> getIterator(){
		return items.getListItems().iterator();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<ConcreteItemProperty> getItemData() {
		return itemData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("G&R Shop Online");

		initRootLayout();
		showHomePage();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showWelcomePage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/WelcomePage.fxml"));
			AnchorPane welcomePage = (AnchorPane) loader.load();

			rootLayout.setCenter(welcomePage);

			HomePageController hPC = loader.getController();
			hPC.setMain(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHomePage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/HomePage.fxml"));
			AnchorPane homePage = (AnchorPane) loader.load();

			rootLayout.setCenter(homePage);

			HomePageController hPC = loader.getController();
			hPC.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}