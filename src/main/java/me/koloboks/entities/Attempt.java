package me.koloboks.entities;

import javax.persistence.*;

/**
 * Created by Kirill Maloyaroslavtsev on 23.05.16.
 */
@Entity
@Table
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @Column
    private String value;

    @Column(name="STRING_COMMENT")
    private String stringComment;

    public Attempt() {
    }

    public Attempt(Game game, String value, String stringComment) {
        this.game = game;
        this.value = value;
        this.stringComment = stringComment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStringComment() {
        return stringComment;
    }

    public void setStringComment(String stringComment) {
        this.stringComment = stringComment;
    }
}
