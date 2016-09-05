package gui.view;

import java.io.IOException;

import gui.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {
	private MainFX mainFX;
	
	public MainFX getMainFX() {
		return mainFX;
	}

	public void setMainApp(MainFX mainFx){
		this.setMainFX(mainFx);
	}

	public void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;
	}
	
	@FXML
	private void AboutGeR(ActionEvent actionEvent) throws IOException {	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFX.class.getResource("about/MainAbout.fxml"));
		
		AnchorPane mainAbout = loader.load();

		Stage addMainAbout = new Stage();
		addMainAbout.getIcons().add(new Image("logo_gr.png"));
		addMainAbout.initModality(Modality.WINDOW_MODAL);
		addMainAbout.setTitle("G&R Megastore: about");

		Scene scene = new Scene(mainAbout);
		addMainAbout.setScene(scene);
		addMainAbout.showAndWait();
	}

	@FXML
	private void Close(ActionEvent actionEvent) {
		System.exit(0);
	}
}
