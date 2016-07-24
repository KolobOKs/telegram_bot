package me.koloboks.commons;

/**
 * Created by koloboks on 18.07.16.
 */
public class GameResult {
    private String message;
    private boolean isWin;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public GameResult(String message, boolean isWin) {

        this.message = message;
        this.isWin = isWin;
    }
}
