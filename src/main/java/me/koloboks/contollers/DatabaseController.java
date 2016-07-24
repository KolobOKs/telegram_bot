package me.koloboks.contollers;

import me.koloboks.commons.AttemptInformation;
import me.koloboks.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kirill Maloyaroslavtsev on 18.05.16.
 */
@Component
public class DatabaseController {

    @Autowired
    private PhotoDao photoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GameDao gameDao;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private GameController gameController;

    public DatabaseController() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    public User GetUserByTelegramId(String telegramId){
        return userDao.getUserByTelegramId(telegramId);
    }

    public User createUser(String telegramId){
        User newUser = new User();
        newUser.setTelegramId(telegramId);
        userDao.save(newUser);
        newUser=userDao.getUserByTelegramId(telegramId);
        return newUser;
    }


    public Game getCurrentGameForUser(String telegramId){
        User currentUser=userDao.getUserByTelegramId(telegramId);
        if(currentUser==null){
            currentUser= createUser(telegramId);
            userDao.save(currentUser);
        }

        Game currentGame=gameDao.getCurrentGame(currentUser.getId());
        if(currentGame==null){

            currentGame=new Game(currentUser,1,0, gameController.getRandomGameNumber());
            gameDao.save(currentGame);
        }
        return currentGame;
    }

    public List<Attempt> getAttempts(Game game){ return new ArrayList<Attempt>(Arrays.asList(attemptDao.getAttemptsForGame(game)));}

    public void saveGame(Game gameToSave){
        gameDao.save(gameToSave);
    }

    public void addNewAttempt(Game game, Attempt attempt){
        List<Attempt> attempts=game.getAttempts();
        if(attempts==null){
            attempts=new ArrayList<Attempt>();
        }
        attempts.add(attempt);
        game.setAttempts(attempts);

        attemptDao.save(attempt);
        gameDao.save(game);
    }

    public void deleteGame(Game game){
        gameDao.delete(game);
    }


}
