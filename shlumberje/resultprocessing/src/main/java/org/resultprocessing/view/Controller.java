package org.resultprocessing.view;

import org.resultprocessing.MainApp;

import javafx.fxml.FXML;

public class Controller {

	private MainApp mainApp;

	@FXML
	private void initialize() {
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public MainApp getMainApp() {
		return mainApp;
	}



}
