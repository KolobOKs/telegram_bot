package me.koloboks.commons;

/**
 * Created by koloboks on 18.07.16.
 */
public class ReplyKeyboardMarkup implements KeyboardMarkup{
    private KeyboardButton[][] keyboard;

    public ReplyKeyboardMarkup(KeyboardButton[][] keyboard) {
        this.keyboard = keyboard;
    }

    public KeyboardButton[][] getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(KeyboardButton[][] keyboard) {
        this.keyboard = keyboard;
    }
}
