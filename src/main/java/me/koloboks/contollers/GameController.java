package me.koloboks.contollers;

import me.koloboks.commons.AttemptInformation;
import me.koloboks.entities.Attempt;
import me.koloboks.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Random;

/**
 * Created by koloboks on 16.07.16.
 */
@Component
public class GameController {

    @Autowired
    private DatabaseController databaseController;

    public AttemptInformation newAttempt(String telegramId, String attempt){
        Game currentGame=databaseController.getCurrentGameForUser(telegramId);
        String attemptResult=checkAttempt(attempt,currentGame.getRightAnswer());
        Attempt newAttempt= new Attempt(currentGame,attempt,attemptResult);
        databaseController.addNewAttempt(currentGame,newAttempt);

        if(attemptResult.equals("4Б 0К")){
            currentGame.setGameType(2);
            databaseController.saveGame(currentGame);
            List<Attempt> previousAttempts=databaseController.getAttempts(currentGame);
            return new AttemptInformation(newAttempt,previousAttempts,true);
        }
        databaseController.saveGame(currentGame);
        List<Attempt> previousAttempts=databaseController.getAttempts(currentGame);
        return new AttemptInformation(newAttempt,previousAttempts,false);
    }
    private  String checkAttempt(String attempt, String rightAnswer){
        int cowsCount=0, bullsCount=0;
        for (int i=0; i<4; i++){
            if(attempt.charAt(i)==rightAnswer.charAt(i)){
                bullsCount++;
            }
        }
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                if(i==j) continue;
                if(rightAnswer.charAt(i)==attempt.charAt(j)){
                    cowsCount++;
                }
            }
        }

        String result="";
        result+=bullsCount + "Б ";
        result+=cowsCount +"К";

        return result;
    }



    public String getRandomGameNumber(){
        Random rnd = new Random();
        int first=rnd.nextInt(9);
        int second, third, fouth;
        do{
            second=rnd.nextInt(9);
        }while(second==first);
        do{
            third=rnd.nextInt(9);
        }while(third==first || third==second);
        do{
            fouth=rnd.nextInt(9);
        }while(fouth==first || fouth==second || fouth==third);
        return Integer.toString(first)+Integer.toString(second)+Integer.toString(third) + Integer.toString(fouth);
    }



    public boolean newGameForUser(String telegramId){
        Game currentGame=databaseController.getCurrentGameForUser(telegramId);
        if(currentGame!=null){
            databaseController.deleteGame(currentGame);
            return true;
        }
        return false;
    }
}
