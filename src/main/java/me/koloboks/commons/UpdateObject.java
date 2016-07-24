package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class UpdateObject {
    @SerializedName("update_id")
    private int updateId;
    private MessageObject message;
    @SerializedName("callback_query")
    public CallbackQuery callbackQuery;

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public void setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    public int getUpdateId() {
        return updateId;
    }

    public MessageObject getMessage() {
        return message;
    }

    public UpdateObject(int updateId, MessageObject message) {

        this.updateId = updateId;
        this.message = message;
    }
}
