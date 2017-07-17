package org.resultprocessing.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResultPositiveController extends Controller{

	@FXML
	private Label nameDetail;

	@FXML
	private ImageView imageDetail;
	@FXML
	private ImageView imageBarcode;

	///////
	@FXML
	private TextField field;
	@FXML
	private Button btn;


	public ResultPositiveController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {
		nameDetail.setText("Detail №1");
		nameDetail.setStyle("-fx-text-fill: red");







	}

	@FXML
	private void showImage(){

		imageDetail.setVisible(true);
	}


}
