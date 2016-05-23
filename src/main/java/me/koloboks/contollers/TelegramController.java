package me.koloboks.contollers;

import com.google.gson.Gson;
import me.koloboks.commons.UpdateObject;
import me.koloboks.methodTypes.GetUpdateRequest;
import me.koloboks.methodTypes.GetUpdateResponse;
import me.koloboks.methodTypes.SendMessageRequest;
import me.koloboks.utils.HttpApacheGateway;
import me.koloboks.utils.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Kirill Maloyaroslavtsev on 13.05.16.
 */
public class TelegramController {
    private int lastUpdateId=0;
    private Gson gson = new Gson();

    public void GetUpdates() throws InterruptedException {
        while (true) {
            try {
                HttpResponse response = HttpApacheGateway.postRequest("getUpdates", lastUpdateId == 0 ? null : new GetUpdateRequest(lastUpdateId + 1));
                if (response.getReponseCode() == 200) {
                    GetUpdateResponse serializedResponse = gson.fromJson(response.GetResponseBody(), GetUpdateResponse.class);
                    if (serializedResponse.getResult().length > 0) {
                        // do something
                        for (UpdateObject updateObject : serializedResponse.getResult()) {
                            lastUpdateId = updateObject.getUpdateId();
                            System.out.println("Got new message " + updateObject.getUpdateId() + " from " + updateObject.getMessage().getFrom().getUsername()+
                            " : " + updateObject.getMessage().getText());

                            // sending testing message
//                            SendMessageRequest testMessage = new SendMessageRequest(updateObject.getMessage().getChat().getId(),
//                                    "Я получил твое сообщение: "+updateObject.getMessage().getText());
                            SendMessageRequest testMessage = new SendMessageRequest(updateObject.getMessage().getChat().getId(),
                                    "<b>Попытка 4</b>\n" +
                                            "1234 Б К\n" +
                                            "5678 К К\n" +
                                            "0912 Б К К\n" +
                                            "<b>5678 К К</b>\n" +
                                            "<pre>Осталось 3 попытки</pre>","HTML");
                            HttpResponse a=HttpApacheGateway.postRequest("sendMessage",testMessage);
                            File f = new File("/Users/KolobOKs/Desktop/nf/2.jpg");
                            HttpResponse ff=HttpApacheGateway.postFileRequest("sendPhoto",updateObject.getMessage().getChat().getId(),f);
                        }
                    }
                    else {
                        System.out.println("No new messages");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);
        }
    }
}
