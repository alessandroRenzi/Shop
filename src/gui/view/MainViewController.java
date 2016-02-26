package gui.view;

import java.io.IOException;

import gui.MainFX;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainViewController {
	@FXML
	public void Close(ActionEvent actionEvent) {
		Platform.exit();
	}

	@FXML
	public void AboutGeR(ActionEvent actionEvent) throws IOException {
		MainFX.showMainAbout();
	}
}
