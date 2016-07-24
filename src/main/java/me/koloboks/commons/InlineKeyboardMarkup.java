package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koloboks on 24.07.16.
 */
public class InlineKeyboardMarkup implements KeyboardMarkup {
    @SerializedName("inline_keyboard")
    private InlineKeyboardButton[][] inlineKeyboard;

    public InlineKeyboardButton[][] getInlineKeyboard() {
        return inlineKeyboard;
    }

    public void setInlineKeyboard(InlineKeyboardButton[][] inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    public InlineKeyboardMarkup(InlineKeyboardButton[][] inlineKeyboard) {

        this.inlineKeyboard = inlineKeyboard;
    }
}
