package application.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainView {
	Label timeRemainingLabel;
	Label scoreLabel;
	ImageView[] imageViews;
	
	public MainView() {
		this.timeRemainingLabel = new Label();
		this.scoreLabel = new Label();
		imageViews = new ImageView[5];
	}
	
	public void setTimeRemainingLabel(Label lb) {
		this.timeRemainingLabel = lb;
	}
	
	public void scoreLabel(Label lb) {
		this.scoreLabel = lb;
	}
	
	public void displayTimeRemaining(String time) {
		// TODO
	}
	
	// This displays the score
	public void displayLabel(String score) {
		// TODO
	}
	
	public void displayImage(int index, Image image) {
		// TODO
	}

}
