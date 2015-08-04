package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<IUser> users;

    public UserDatabase(ArrayList<IUser> users) {
        this.users = users;
    }

    public boolean checkCredentials(String libraryNumber, String password) {
        for(IUser user : users) {
            if(user.hasCredentials(libraryNumber, password))
                return true;
        }
        return false;
    }

    public IUser login(String libraryNumber, String password) {
        for(IUser user : users) {
            if(user.hasCredentials(libraryNumber, password))
                return user;
        }
        return new NullUser();
    }
}
