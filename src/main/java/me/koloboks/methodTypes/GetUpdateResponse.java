package me.koloboks.methodTypes;

import me.koloboks.commons.UpdateObject;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class GetUpdateResponse {
    private boolean ok;
    private UpdateObject[] result;

    public GetUpdateResponse(UpdateObject[] result, boolean ok) {
        this.result = result;
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }

    public UpdateObject[] getResult() {
        return result;
    }
}
