package me.koloboks.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kirill Maloyaroslavtsev on 23.05.16.
 */
@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name="GAME_TYPE")
    private int gameType;

    @Column(name="ATTEMPT_COUNT")
    private int attemntCount;

    @Column(name="RIGHT_ANSWER")
    private String rightAnswer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game",cascade= CascadeType.REMOVE)
    private List<Attempt> attempts;

    public Game() {
    }

    public Game(User user, int gameType, int attemntCount, String rightAnswer) {
        this.user = user;
        this.gameType = gameType;
        this.attemntCount = attemntCount;
        this.rightAnswer = rightAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public int getAttemntCount() {
        return attemntCount;
    }

    public void setAttemntCount(int attemntCount) {
        this.attemntCount = attemntCount;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }
}
