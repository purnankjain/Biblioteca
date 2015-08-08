package com.twu.biblioteca.user;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<User> users;

    public UserDatabase(ArrayList<User> users) {
        this.users = users;
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
        return new User("", "", "", "", "", null, UserRoles.NULL_USER);
    }
}
