package application.model;

import application.view.MainView;

public class CountDownTimer implements Runnable {

    private WhackAMole game; // Reference to the main game
    private int durationSeconds; // Time remaining in seconds
    private MainView mainView;

    public CountDownTimer(WhackAMole game, MainView mainview) {
        this.game = game;
        this.durationSeconds = 30; // Game duration
        this.mainView = mainview;
    }

    @Override
    public synchronized void run() {
        while (durationSeconds > 0) {
            try {
                // Update the label in the game
                game.updateScore(durationSeconds);
                
                // Wait for 1 second
                Thread.sleep(1000);
                
                // Decreases the remaining time
                durationSeconds--;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        //label shows 0 at the end
        mainView.displayTimeRemaining("0");
        // End the game when the time is up
        game.endGame();
    }
}


