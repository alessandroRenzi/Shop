package gui.view;

import gui.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HomePageController {
	@FXML
	private TableView<ConcreteItemProperty> itemTable;
	@FXML
	private TableColumn<ConcreteItemProperty, String> firstNameColumn;
	private Main main;

	public HomePageController() {

	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getCategory());
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
		itemTable.setItems(main.getItemData());
	}	
}
