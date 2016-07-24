package me.koloboks.methodTypes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koloboks on 24.07.16.
 */
public class AnswerCallbackQueryRequest {
    @SerializedName("callback_query_id")
    private String callbackQueryId;
    private String text;
    @SerializedName("show_alert")
    private boolean showAlert;

    public String getCallbackQueryId() {
        return callbackQueryId;
    }

    public void setCallbackQueryId(String callbackQueryId) {
        this.callbackQueryId = callbackQueryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isShowAlert() {
        return showAlert;
    }

    public void setShowAlert(boolean showAlert) {
        this.showAlert = showAlert;
    }

    public AnswerCallbackQueryRequest(String callbackQueryId, String text, boolean showAlert) {

        this.callbackQueryId = callbackQueryId;
        this.text = text;
        this.showAlert = showAlert;
    }
}
