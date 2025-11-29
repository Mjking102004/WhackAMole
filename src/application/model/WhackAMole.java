package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;

public class WhackAMole {
    private MainView mainView;
    private CountDownTimer timer;
    private Mole[] moles;
    private Thread[] moleThreads;
    private boolean[] exposed;
    private long[] exposedStartTimes;
    private int totalScore;
    private volatile boolean gameOver;

    public WhackAMole(MainView mainView) {
        this.mainView = mainView;
        moles = new Mole[5];
        moleThreads = new Thread[5];
        exposed = new boolean[5];
        exposedStartTimes = new long[5];
        gameOver = true;
        totalScore = 0;
    }

    public synchronized void setExposed(int index, boolean expsd) {
        exposed[index] = expsd;
    }

    public synchronized void setExposedStartTime(int index, long timeMillis) {
        exposedStartTimes[index] = timeMillis;
    }

    public void startGame() {
        if (!gameOver) {
            return;
        }

        totalScore = 0;
        for (int i = 0; i < exposed.length; ++i) {
            exposed[i] = false;
            exposedStartTimes[i] = 0L;
        }
        mainView.displayScore(String.valueOf(totalScore));
        mainView.displayTimeRemaining(String.valueOf(30));

        gameOver = false;

        timer = new CountDownTimer(this, mainView);
        Thread timerThread = new Thread(timer);
        timerThread.start();
        Random rand = new Random();

        for (int i = 0; i < 5; ++i) {
            moles[i] = new Mole(this, mainView, i, rand);
            moleThreads[i] = new Thread(moles[i]);
            moleThreads[i].start();
        }
    }

    public void endGame() {
        gameOver = true;

        for (Thread t : moleThreads) {
            if (t != null) {
                t.interrupt();
            }
        }
    }


    public void whackMole(int index) {
        long elapsed = 0;
        boolean wasExposed;
        synchronized (this) {
            if (index < 0 || index >= exposed.length) return;
            wasExposed = exposed[index];
            if (wasExposed) {
                elapsed = System.currentTimeMillis() - exposedStartTimes[index];
                exposed[index] = false;
            }
        }
        if (wasExposed) {
            updateScore(elapsed);
            mainView.displayImage(index, null);
        }
    }

    public synchronized void updateScore(long responseTimeMillis) {
        if (responseTimeMillis < 500) {
            totalScore += 100;
        } else if (responseTimeMillis < 1000) {
            totalScore += 50;
        } else {
            totalScore += 10;
        }
        mainView.displayScore(String.valueOf(totalScore));
    }

    public boolean gameOver() {
        return gameOver;
    }

}

