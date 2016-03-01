package gui.items;

import gui.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainItemsController {
	@FXML
	private TableView<CategoryModelClass> categoryTable;
	@FXML
	private TableView<ItemsModelClass> itemTable;
	@FXML
	private TableColumn<CategoryModelClass, String> categoryColumn;
	@FXML
	private TableColumn<ItemsModelClass, String> itemsColumn;

	private MainFX mainFX;

	@FXML
	private void initialize() {
		itemsColumn.setCellValueFactory(cellData -> cellData.getValue().getDescriptionProperty());
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().getCategoryProperty());
	}

	@FXML 
	private void showCategoryItems(ActionEvent actionEvent){

	}

	public void setMain(MainFX mainFx){
		this.mainFX = mainFx;
		itemTable.setItems(mainFX.getObservableListItems());
		categoryTable.setItems(mainFx.getObservableListCategory());
	}
}
