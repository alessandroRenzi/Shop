package gui.items;

import gui.MainFX;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainItemsController {
	@FXML
	private TableView<ItemsModelClass> itemTable;
	@FXML
	private TableColumn<ItemsModelClass, String> categoryColumn;
	private MainFX mainFX;

	public MainItemsController() {

	}

	@FXML
	private void initialize() {
		itemTable.setItems(mainFX.getObservableList());
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
	}
}
