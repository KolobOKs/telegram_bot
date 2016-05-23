package me.koloboks.utils;

/**
 * Created by Kirill Maloyaroslavtsev on 16.05.16.
 */
public class HttpResponse {
    private int responseCode;
    private String responseBody;

    public int getReponseCode(){
        return responseCode;
    }

    public String GetResponseBody(){
        return responseBody;
    }

    public HttpResponse(int responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }
}
