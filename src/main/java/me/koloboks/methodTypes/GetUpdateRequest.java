package me.koloboks.methodTypes;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class GetUpdateRequest {
    private int offset;

    public int getOffset() {
        return offset;
    }

    public GetUpdateRequest(int offset) {

        this.offset = offset;
    }
}
