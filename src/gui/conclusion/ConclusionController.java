package gui.conclusion;

import gui.summary.SummaryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ConclusionController {
	@FXML
	private Button exit;
	@FXML
	private Label name;
	
	private SummaryController mainSC;
	
	public SummaryController getMainSC() {
		return mainSC;
	}
	
	public void setMainSC(SummaryController mainSC) {
		this.mainSC = mainSC;
	}

	public void setSummaryController(SummaryController mainSC) {
		this.setMainSC(mainSC);
		this.name.setText(this.mainSC.getMainCC().getName());
	}
	
	@FXML
	public void exitEvent(ActionEvent event) {
		System.exit(0);
	}
}
