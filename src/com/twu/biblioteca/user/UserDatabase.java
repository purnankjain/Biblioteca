package com.twu.biblioteca.user;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<User> users;
    User nullUser;

    public UserDatabase(ArrayList<User> users, User nullUser) {
        this.users = users;
        this.nullUser = nullUser;
    }

    public boolean checkCredentials(String libraryNumber, String password) {
        for(User user : users) {
            if(user.hasCredentials(libraryNumber, password))
                return true;
        }
        return false;
    }

    public User login(String libraryNumber, String password) {
        for(User user : users) {
            if(user.hasCredentials(libraryNumber, password)) {
                return user;
            }
        }
        return nullUser;
    }

    public User logout() {
        return nullUser;
    }
}
