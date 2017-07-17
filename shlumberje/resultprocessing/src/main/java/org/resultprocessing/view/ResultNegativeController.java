package org.resultprocessing.view;

import org.resultprocessing.model.Detail;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ResultNegativeController extends Controller {

	@FXML
	private Label detail1;

	@FXML
	private Label detail2;

	@FXML
	private Label detail3;

	public ResultNegativeController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {

		//detail1.setText("Деталь 1");
		//detail2.setText("Деталь 2");
		//detail3.setText("Деталь 3");

		Group root = new Group();
		//Detail detail = new Detail("");



		//root.getChildren().add(detail.showDetail());
		//Scene scene = new Scene(root, 300, 300, Color.LIGHTGREEN);
		//getMainApp().getPrimaryStage().setScene(scene);




	}

}
