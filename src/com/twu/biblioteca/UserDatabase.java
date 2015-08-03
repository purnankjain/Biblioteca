package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<User> users;

    public UserDatabase(ArrayList<User> users) {
        this.users = users;
    }

    public boolean checkCredentials(String id, String password) {
        for(User user : users) {
            if(user.hasCredentials(id, password))
                return true;
        }
        return false;
    }
}
