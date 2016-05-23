package me.koloboks.contollers;

import me.koloboks.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Kirill Maloyaroslavtsev on 18.05.16.
 */
@Component
public final class DatabaseController {

    @Autowired
    private PhotoDao photoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GameDao gameDao;

    public DatabaseController() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public void TestMethod(){

            Photo  p=photoDao.findOne(new Long(1));
            Photo p2 = photoDao.findByName ("test");
            Iterable<Photo> p3 = photoDao.findAll();

            User user = new User();
        user.setStatus(1);
        user.setTelegramId("koloboks");

        Game game1 = new Game(user,1,1,1);
        Game game2 = new Game(user,2,2,2);

        List<Game> gamesList = new ArrayList<>();
        gamesList.add(game1);
        gamesList.add(game2);

        user.setGames(gamesList);
//
//        gameDao.save(game1);
//        gameDao.save(game2);

        userDao.save(user);
        gameDao.save(gamesList);

        Iterable<User> users=userDao.findAll();
        for (User user1 : users) {
            System.out.println(user1.getId() + "" + user1.getGames().size());
        }

        users.getClass();
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
//        Session session = sessionFactory.openSession();
//        List<Photo> photoList=(List<Photo>)(session.createQuery("from Photo").list());
//        session.close();

    }

}
