package application.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainView {
	Label timeRemainingLabel;
	Label scoreLabel;
	ImageView[] imageViews;
	
	public MainView(Label timeLabel, Label scoreLabel, ImageView[] images) {
		this.timeRemainingLabel = timeLabel;
		this.scoreLabel = scoreLabel;
		imageViews = images;
	}
	
	public void displayScore(String score) {
		scoreLabel.setText(score);
	}
	
	public void displayTimeRemaining(String time) {
		timeRemainingLabel.setText(time);
	}
	
	public void displayImage(int index, Image image) {
		imageViews[index].setImage(image);
	}

}
