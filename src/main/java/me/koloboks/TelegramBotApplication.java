package me.koloboks;

import jdk.nashorn.internal.runtime.Debug;
import me.koloboks.contollers.DatabaseController;
import me.koloboks.contollers.TelegramController;
import me.koloboks.utils.HttpApacheGateway;
import me.koloboks.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class TelegramBotApplication {



	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, InterruptedException {
        ApplicationContext ctx = SpringApplication.run(new Class<?>[] {TelegramBotApplication.class, JpaConfig.class}, args);
        DatabaseController databaseController = (DatabaseController)ctx.getBean("databaseController");

        TelegramController c = new TelegramController();
        databaseController.TestMethod();

        c.GetUpdates();

	}
}
