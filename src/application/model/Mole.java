package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;

public class Mole implements Runnable {
	private WhackAMole game;
	private MainView mainView;
	private Image moleImage;
	private int index;
	private Random rand;
	
	public Mole(WhackAMole game, MainView mainview) {
		moleImage = new Image(getClass().getResourceAsStream("mole.png"));
		// TODO
	}
	
	public synchronized void run() {
        // TODO
    }
}
