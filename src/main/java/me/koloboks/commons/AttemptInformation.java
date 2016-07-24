package me.koloboks.commons;

import me.koloboks.entities.Attempt;

import java.util.List;

/**
 * Created by koloboks on 16.07.16.
 */
public class AttemptInformation {
    private Attempt currentAttempt;
    private List<Attempt> previousAttempts;
    private boolean isWin;

    public AttemptInformation(Attempt currentAttempt, List<Attempt> previousAttempts, boolean isWin) {
        this.currentAttempt = currentAttempt;
        this.previousAttempts = previousAttempts;
        this.isWin = isWin;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public List<Attempt> getPreviousAttempts() {
        return previousAttempts;
    }

    public void setPreviousAttempts(List<Attempt> previousAttempts) {
        this.previousAttempts = previousAttempts;
    }

    public Attempt getCurrentAttempt() {
        return currentAttempt;
    }

    public void setCurrentAttempt(Attempt currentAttempt) {
        this.currentAttempt = currentAttempt;
    }
}
