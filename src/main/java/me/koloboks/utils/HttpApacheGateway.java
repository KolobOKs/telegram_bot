package me.koloboks.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Kirill Maloyaroslavtsev on 13.05.16.
 */
public final class HttpApacheGateway {
    private static CloseableHttpClient httpClient = HttpClients.custom().
            setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

    private static String botUrl= "https://api.telegram.org/bot196308424:AAEYfLTzvFxGiB6AHf1gKva49t5vBfk8FmM/";

    private static Gson gson = new Gson();

    public static me.koloboks.utils.HttpResponse getRequest (String url) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        HttpGet request = new HttpGet(url);

        HttpResponse response = httpClient.execute(request);
        int statusCode=response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line;
        while((line=rd.readLine())!=null){
            result.append(line);
        }

        return new me.koloboks.utils.HttpResponse(statusCode, result.toString());
    }


    public static me.koloboks.utils.HttpResponse postRequest(String methodName, Object requestBody) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException{
        HttpPost requestPost = new HttpPost(botUrl+methodName);
        requestPost.addHeader("Content-Type","application/json");

        StringEntity entity= new StringEntity(gson.toJson(requestBody),"UTF-8");
        requestPost.setEntity(entity);
        HttpResponse response = httpClient.execute(requestPost);
        int statusCode=response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line;
        while((line=rd.readLine())!=null){
            result.append(line);
        }

        return new me.koloboks.utils.HttpResponse(statusCode, result.toString());
    }

    public static me.koloboks.utils.HttpResponse postFileRequest(String methodName,int chatId, File file) throws IOException {
        HttpPost requestPost = new HttpPost(botUrl+"sendPhoto");
        //requestPost.addHeader("Content-Type","multipart/form-data");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("chat_id", String.valueOf(chatId), ContentType.TEXT_PLAIN);
        builder.addBinaryBody("photo", file, ContentType.APPLICATION_OCTET_STREAM, "photo.jpg");
        requestPost.setEntity(builder.build());
        HttpResponse response = httpClient.execute(requestPost);
        int statusCode=response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line;
        while((line=rd.readLine())!=null){
            result.append(line);
        }

        return new me.koloboks.utils.HttpResponse(statusCode, result.toString());
    }
}
