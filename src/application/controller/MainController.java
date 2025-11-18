package application.controller;

import application.model.WhackAMole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainController {
	private WhackAMole game;
	
	@FXML private Label timeRemaining;
	@FXML private Label scoreLabel;
	
	@FXML private ImageView imageView0;
	@FXML private ImageView imageView1;
	@FXML private ImageView imageView2;
	@FXML private ImageView imageView3;
	@FXML private ImageView imageView4;
	@FXML private Pane pane0;
	@FXML private Pane pane1;
	@FXML private Pane pane2;
	@FXML private Pane pane3;
	@FXML private Pane pane4;
	
	@FXML
    public void initialize() {
		// TODO
	}
	
	public void imageViewAction(ActionEvent event) {
		// TODO
	}
	
	public void startButtonAction(ActionEvent event) {
		// TODO
	}

}
