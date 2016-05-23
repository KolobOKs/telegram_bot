package me.koloboks.commons;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class SendMessageRequest {
    private String chatId;
    private String text;

    public SendMessageRequest(String chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
