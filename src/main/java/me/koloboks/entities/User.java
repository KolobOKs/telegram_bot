package me.koloboks.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Kirill Maloyaroslavtsev on 23.05.16.
 */
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="TELEGRAM_ID")
    private String telegramId;

    @Column
    private int status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Game> Games;

    public User() {
    }

    public User(String telegramId, int status) {
        this.telegramId = telegramId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Game> getGames() {
        return Games;
    }

    public void setGames(List<Game> games) {
        Games = games;
    }
}
