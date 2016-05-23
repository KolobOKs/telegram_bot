package me.koloboks.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kirill Maloyaroslavtsev on 18.05.16.
 */
@Entity
@Table
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String telegramFileId;

    public Photo() {
    }

    public Photo(String name, String telegramFileId) {
        this.name = name;
        this.telegramFileId = telegramFileId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelegramFileId() {
        return telegramFileId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelegramFileId(String telegramFileId) {
        this.telegramFileId = telegramFileId;
    }
}
