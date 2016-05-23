package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class MessageObject {
    @SerializedName("message_id")
    private int messageId;
    private UserObject from;
    private int date;
    private ChatObject chat;
    private String text;

    public String getText() {
        return text;
    }

    public MessageObject(int messageId, UserObject from, int date, ChatObject chat, String text) {
        this.messageId = messageId;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.text = text;
    }

    public int getMessageId() {
        return messageId;
    }

    public UserObject getFrom() {
        return from;
    }

    public int getDate() {
        return date;
    }

    public ChatObject getChat() {
        return chat;
    }
}
