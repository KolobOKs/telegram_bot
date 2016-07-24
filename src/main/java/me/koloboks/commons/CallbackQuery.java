package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;
import me.koloboks.entities.User;
import sun.plugin2.message.Message;

/**
 * Created by koloboks on 24.07.16.
 */
public class CallbackQuery {
    private String id;
    private UserObject user;
    private MessageObject message;
    @SerializedName("inline_message_id")
    private String inlineMessageId;
    private String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserObject getUser() {
        return user;
    }

    public void setUser(UserObject user) {
        this.user = user;
    }

    public MessageObject getMessage() {
        return message;
    }

    public void setMessage(MessageObject message) {
        this.message = message;
    }

    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public void setInlineMessageId(String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
