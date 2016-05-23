package me.koloboks.methodTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class SendMessageRequest {
    @SerializedName("chat_id")
    private int chatId;
    private String text;
    @SerializedName("parse_mode")
    private String parseMode;

    public SendMessageRequest(int chatId, String text, String parseMode) {
        this.chatId = chatId;
        this.text = text;
        this.parseMode = parseMode;
    }

    public String getParseMode() {

        return parseMode;
    }

    public int getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public SendMessageRequest(int chatId, String text) {

        this.chatId = chatId;
        this.text = text;
    }
}
