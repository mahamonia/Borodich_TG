package org.resultprocessing.model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Detail {

	private Label name;
	private ImageView imageDetail;
	private ImageView imageBarcode;

	public Detail(String name) {
		this.name = new Label();

		this.name.setText(name);

		// IMAGE DETAIL

		imageDetail = new ImageView();
		Image valueDetail = new Image("/org/resultprocessing/view/image.jpeg");
		imageDetail.setImage(valueDetail);
		imageDetail.setLayoutX(20);
		imageDetail.setLayoutY(40);

		imageDetail.setFitHeight(200);
		imageDetail.setFitWidth(200);

		// IMAGE CODE

		imageBarcode = new ImageView();
		Image valueBarcode = new Image("/org/resultprocessing/view/barcode-image.jpg");
		imageBarcode.setImage(valueBarcode);

		imageBarcode.setLayoutX(320);
		imageBarcode.setLayoutY(40);

		imageBarcode.setFitHeight(200);
		imageBarcode.setFitWidth(200);

	}

	public Detail showDetail() {
		return this;
	}

	public Label getName() {
		return name;
	}

	public void setName(Label name) {
		this.name = name;
	}

	public ImageView getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(ImageView imageDetail) {
		this.imageDetail = imageDetail;
	}

	public ImageView getImageCode() {
		return imageBarcode;
	}

	public void setImageCode(ImageView imageCode) {
		this.imageBarcode = imageCode;
	}

}
