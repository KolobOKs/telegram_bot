package me.koloboks.methodTypes;

import com.google.gson.annotations.SerializedName;
import me.koloboks.commons.KeyboardMarkup;

/**
 * Created by koloboks on 24.07.16.
 */
public class EditMessageTextRequest {
    @SerializedName("chat_id")
    private String chatId;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @SerializedName("message_id")
    private int messageId;
    @SerializedName("inline_message_id")
    private String inlineMessageId;
    private String text;
    @SerializedName("parse_mode")
    private String parseMode;
    @SerializedName("reply_markup")
    private KeyboardMarkup replyMarkup;

    public EditMessageTextRequest(String chatId, int messageId, String inlineMessageId, String text) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.text = text;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public void setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    public KeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(KeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
