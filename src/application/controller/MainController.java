package application.controller;

import application.model.WhackAMole;
import application.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainController {
    private WhackAMole game;
    private MainView view;

    @FXML private Label timeRemainingLabel;
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
        pane0.setStyle("-fx-border-color: black;");
        pane1.setStyle("-fx-border-color: black;");
        pane2.setStyle("-fx-border-color: black;");
        pane3.setStyle("-fx-border-color: black;");
        pane4.setStyle("-fx-border-color: black;");

        ImageView[] images = {imageView0, imageView1, imageView2, imageView3, imageView4};

        view = new MainView(timeRemainingLabel, scoreLabel, images);

        game = new WhackAMole(view);

        imageView0.setUserData(0);
        imageView1.setUserData(1);
        imageView2.setUserData(2);
        imageView3.setUserData(3);
        imageView4.setUserData(4);
        
    }

    @FXML
    public void imageViewAction(Event event) {
        ImageView clicked = (ImageView) event.getSource();
        int index = (int) clicked.getUserData();
        game.whackMole(index);
    }

    @FXML
    public void startButtonAction(ActionEvent event) {
        game.startGame();
    }

}

