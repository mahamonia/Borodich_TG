package org.resultprocessing;

import java.net.URL;
import java.util.List;

import org.resultprocessing.model.DataBase;
import org.resultprocessing.model.Detail;
import org.testresultscan.ResultScan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private Pane rootLayout;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Result Scanner Processing");

		ResultScan resultScan = new ResultScan();
		Boolean result = true;//resultScan.getResultScan();

		URL resource = null;
		System.out.println(result);

		if (result) {
			resource = MainApp.class.getResource("/org/resultprocessing/view/resultScanPositive.fxml");
			initLayoutSuccessfulSearch(resource);
		} else{
			resource = MainApp.class.getResource("/org/resultprocessing/view/resultScanNegative.fxml");
			initLayoutAddDetail(resource);
		}

		//test();

	}

	public void initLayoutSuccessfulSearch(URL resource) {
		try {

			//FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(resource);
			//rootLayout = loader.load();

			Group root = new Group();
			Detail detail = new Detail("right detail");

			detail.getName().setLayoutX(20);
			detail.getName().setLayoutY(20);

			root.getChildren().add(detail.getName());
			root.getChildren().add(detail.getImageDetail());
			root.getChildren().add(detail.getImageCode());

			Scene scene = new Scene(root, 600, 600);
			primaryStage.setScene(scene);

			//Controller controller = loader.getController();
			//controller.setMainApp(this);

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initLayoutAddDetail(URL resource) {
		try {
			DataBase dataBase = new DataBase();

			FlowPane root = new FlowPane();
			root.setHgap(10);
	        root.setVgap(20);
	        root.setPadding(new Insets(15,15,15,15));
			List<Detail> list = dataBase.getListDetails();

			double border = 0;
			for (Detail detail : list) {
				border += 100;
				detail.getName().setLayoutX(border);
				detail.getName().setLayoutY(30);
				root.getChildren().add(detail.getName());

			}


			Scene scene = new Scene(root, (primaryStage.getWidth()+1000), (primaryStage.getHeight()+1000));
			primaryStage.setScene(scene);

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Pane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(Pane rootLayout) {
		this.rootLayout = rootLayout;
	}

	Button btn;
	public void test(){

		Group root = new Group();

		btn = new Button();
		btn.setLayoutX(20);
		btn.setLayoutY(20);
		btn.setText("Тестировать свойства");

		btn.setOnAction(new EventHandler<ActionEvent>() {

		public void handle(ActionEvent event) {
			System.out.println("Свойства, унаследованные от класса Node:"+"\n"+
					"Свойство blendMode: "+btn.blendModeProperty().getValue()+"\n"+
					"Свойство boundsInLocal: "+btn.boundsInLocalProperty().getValue()+"\n");

		} });


		Button btnON;
		btnON=ButtonBuilder.create().build();
		btnON.setLayoutX(20);
		btnON.setLayoutY(150);
		btnON.setText("Установить свойства");
		btnON.setStyle("-fx-font: bold italic 12pt Arial;-fx-text-fill: #660000;"+
		"-fx-background-color: #ff99ff; -fx-border-width: 3px; -fx-border-radius: 30;"+
		"-fx-background-radius: 30;-fx-border-color: #660066;" );

		btnON.setPrefSize(200,30);
		btnON.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {

			btn.setBlendMode(BlendMode.DARKEN);
			javafx.scene.shape.Circle clip=new javafx.scene.shape.Circle(75,53,80);
			btn.setClip(clip);
			btn.setCursor(Cursor.CLOSED_HAND);
			DropShadow effect=new DropShadow();
			effect.setOffsetX(10);
			effect.setOffsetY(10);
			btn.setEffect(effect);
			//btn.setManaged(false);
			//btn.setMouseTransparent(true);
			btn.setOpacity(0.5);
			btn.setRotate(10);
			btn.setLayoutX(80);
			btn.setScaleX(1.8);
			btn.setLayoutY(170);
			btn.setTranslateZ(-50);
			btn.setPrefSize(150,100);
			btn.setTooltip(new Tooltip
			("Это кнопка тестирования свойств класса Button"));
			Image im=new Image(this.getClass().getResource("/org/resultprocessing/view/image.jpeg").toString());
			ImageView imv=new ImageView(im);
			imv.setFitHeight(50);
			imv.setFitWidth(50);
			btn.setGraphic(imv);
			btn.setStyle("-fx-font: bold italic 10pt Helvetica;");

			btn.setAlignment(Pos.CENTER);
			btn.setContentDisplay(ContentDisplay.RIGHT);
			btn.setUnderline(true);
			btn.setWrapText(true);
			//btn.setCancelButton(true);
			//btn.toBack();

		}});


		root.getChildren().add(btnON);
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 300, Color.LIGHTGREEN);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
