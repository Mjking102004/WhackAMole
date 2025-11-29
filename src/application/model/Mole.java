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
	private long exposedStartTime;
	
	public Mole(WhackAMole game, MainView mainview, int index, Random rand) {
		this.game = game;
		this.mainView = mainview;
		this.moleImage = new Image(getClass().getResourceAsStream("/mole.png"));
		this.index = index;
		this.rand = rand;
	}
	
	public void run() {
		while (!game.gameOver()) {
			game.setExposed(index, false);
			mainView.displayImage(index, null);
			
			int hiddenTime = rand.nextInt(3001) + 2000;
			
			try {
				Thread.sleep(hiddenTime);
			} catch (InterruptedException e) {
				if (game.gameOver()) {
					return;
				}
			}
			
			mainView.displayImage(index,moleImage);
			game.setExposed(index, true);
			
			exposedStartTime = System.currentTimeMillis();
			int showTime = rand.nextInt(1001) + 1000;
			
			try {
				Thread.sleep(showTime);
			} catch (InterruptedException e) {
				if (game.gameOver()) {
					return;
				}
				long elapsed = System.currentTimeMillis() - exposedStartTime;
				game.updateScore(elapsed);
				}
			
			mainView.displayImage(index, null);
			game.setExposed(index, false);
		}
	}
}
