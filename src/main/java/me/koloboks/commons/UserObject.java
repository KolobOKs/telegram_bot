package me.koloboks.commons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kirill Maloyaroslavtsev on 17.05.16.
 */
public class UserObject {
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String username;

    public UserObject(int id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public int getId() {

        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }
}
