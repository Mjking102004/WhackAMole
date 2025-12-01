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
        while (durationSeconds > 0 && !game.gameOver()) {
            try {
                final String timeText = Integer.toString(durationSeconds);

                Platform.runLater(() -> mainView.displayTimeRemaining(timeText));

                Thread.sleep(1000);
                durationSeconds--;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        // <-- wrap the last update on FX thread
        Platform.runLater(() -> mainView.displayTimeRemaining("0"));

        // End the game (game.endGame() is probably fine here if it does not touch UI directly)
        game.endGame();
    }
}




