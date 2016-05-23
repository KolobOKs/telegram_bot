package me.koloboks.methodTypes;

import me.koloboks.commons.MessageObject;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class SendMessageResponse {
    private boolean ok;
    private MessageObject result;

    public boolean isOk() {
        return ok;
    }

    public MessageObject getResult() {
        return result;
    }

    public SendMessageResponse(boolean ok, MessageObject result) {

        this.ok = ok;
        this.result = result;
    }
}
