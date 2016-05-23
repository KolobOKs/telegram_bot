package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class ChatObject {
    private int id;
    private String type;
    private String title;
    private String username;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;

    public ChatObject(int id, String type, String title, String username, String firstName, String lastName) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
