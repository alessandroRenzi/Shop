package gui.items;

import gui.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainItemsController {
	@FXML
	private TableColumn<CategoryModelClass, String> categoryColumn;
	@FXML
	private TableView<CategoryModelClass> categoryTable;
	@FXML
	private TableColumn<ItemsModelClass, String> itemsColumn;
	@FXML
	private TableView<ItemsModelClass> itemTable;

	private MainFX mainFX;

	public MainFX getMainFX() {
		return mainFX;
	}

	private void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;
	}

	@FXML
	private void initialize() {
		itemsColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
	}

	public void setMain(MainFX mainFX){
		setMainFX(mainFX);
		itemTable.setItems(mainFX.getObservableListItems());
		categoryTable.setItems(mainFX.getObservableListCategory());
	}

	@FXML 
	private void showCategoryItems(ActionEvent actionEvent){

	}
}
