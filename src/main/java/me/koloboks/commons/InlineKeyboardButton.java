package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koloboks on 24.07.16.
 */
public class InlineKeyboardButton {
    private String text;

    @SerializedName("callback_data")
    private String callbackData;

    public InlineKeyboardButton(String text, String callbackData) {
        this.callbackData = callbackData;
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }
}
