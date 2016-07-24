package me.koloboks.commons;

/**
 * Created by koloboks on 18.07.16.
 */
public class KeyboardButton {
    public String text;

    public KeyboardButton(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
