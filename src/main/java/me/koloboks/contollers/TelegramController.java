package me.koloboks.contollers;

import com.google.gson.Gson;
import me.koloboks.commons.*;
import me.koloboks.entities.Attempt;
import me.koloboks.methodTypes.*;
import me.koloboks.methodTypes.SendMessageRequest;
import me.koloboks.utils.HttpApacheGateway;
import me.koloboks.utils.HttpResponse;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Kirill Maloyaroslavtsev on 13.05.16.
 */


@Component
public class TelegramController {
    private int lastUpdateId=0;
    private Gson gson = new Gson();

    @Autowired
    private GameController gameController;

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

                            MessageObject incomingMessage = updateObject.getMessage();
                            if(incomingMessage==null){
                                CallbackQuery callbackQuery = updateObject.getCallbackQuery();
                                //AnswerCallbackQueryRequest request = new AnswerCallbackQueryRequest(callbackQuery.getId(),"Test", false);
                                //HttpApacheGateway.postRequest("answerCallbackQuery", request);

                                EditMessageTextRequest request2 = new EditMessageTextRequest(
                                        String.valueOf(callbackQuery.getMessage().getChat().getId()),
                                        callbackQuery.getMessage().getMessageId(),
                                        callbackQuery.getInlineMessageId(),callbackQuery.getMessage().getText());
                                request2.setParseMode("HTML");
                                request2.setReplyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton[][]{new InlineKeyboardButton[]{
                                        new InlineKeyboardButton("Правила игры", "/kiski"),
                                        new InlineKeyboardButton("Статистика", "/cats")
                                },
                                        new InlineKeyboardButton[]{
                                                new InlineKeyboardButton("Выбрать тип призовых картинок", "/setpricetype")
                                        },
                                        new InlineKeyboardButton[]{
                                                new InlineKeyboardButton("Назад", "/back")
                                        }
                                }
                                ));
                                HttpResponse response1=HttpApacheGateway.postRequest("editMessageText", request2);
                                continue;
                            }


                            System.out.println("Got new message " + updateObject.getUpdateId() + " from " + incomingMessage.getFrom().getUsername()+
                            " : " + incomingMessage.getText());

                            if(incomingMessage.getText().matches("^\\d{4}$")){
                                GameResult gameResult=attemptsHandler(incomingMessage.getFrom().getUsername(), incomingMessage.getText());

                                if(gameResult.isWin()){
                                    SendMessageRequest resultMessage = new SendMessageRequest(incomingMessage.getChat().getId(),
                                            gameResult.getMessage(),"HTML");
                                    HttpResponse response1=HttpApacheGateway.postRequest("sendMessage",resultMessage);

                                    File f = new File("/Users/KolobOKs/Desktop/pussy.jpg");
                                    HttpResponse ff=HttpApacheGateway.postFileRequest("sendPhoto",updateObject.getMessage().getChat().getId(),f);

                                }else{
                                    SendMessageRequest resultMessage = new SendMessageRequest(incomingMessage.getChat().getId(),
                                            gameResult.getMessage(),"HTML");

                                    resultMessage.setReplyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton[][]{new InlineKeyboardButton[]{
                                            new InlineKeyboardButton("Новая Игра", "/kiski"),
                                            new InlineKeyboardButton("Меню", "/cats")
                                    }
                                    }
                                    ));

                                    HttpResponse response1=HttpApacheGateway.postRequest("sendMessage",resultMessage);
                                }

                                System.out.println("Successful parse attempt from " +incomingMessage.getFrom().getUsername()+ " : " +
                                incomingMessage.getText());
                            }else if(incomingMessage.getText().equals("Новая игра")) {
                                gameController.newGameForUser(incomingMessage.getFrom().getUsername());
                            }
                            else{
                                System.out.println("Can't parse " + incomingMessage.getText());
                            }


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


    private GameResult attemptsHandler(String telegramId, String attemptString ){
        AttemptInformation attemptInformation=gameController.newAttempt(telegramId,attemptString);

        String message="";

        if(attemptInformation.isWin()){
            message+="<b>Ура! Победа!</b>\n";
            message+="Было загадано число "+attemptString +"\n";
            message+="Тебе понадобилось "+attemptInformation.getPreviousAttempts().size() + " попыток, чтобы угадать его.";
            return new GameResult(message,true);
        }


        if(attemptInformation.getPreviousAttempts().size()>1){
            message+="Предыдущие попытки:\n";
        }
        for (int i=0; i<attemptInformation.getPreviousAttempts().size(); i++){
            if(i==attemptInformation.getPreviousAttempts().size()-1){
                message+="_______________________\n<pre>"+ (i+1) + ": "+ attemptInformation.getPreviousAttempts().get(i).getValue() + " - " +
                        attemptInformation.getPreviousAttempts().get(i).getStringComment() +"</pre>\n";
            }else {
                message += "<pre>" + (i + 1) + ": " + attemptInformation.getPreviousAttempts().get(i).getValue() + " - " +
                        attemptInformation.getPreviousAttempts().get(i).getStringComment() + "</pre>\n";
            }
        }

        return new GameResult(message, false);
    }



}
