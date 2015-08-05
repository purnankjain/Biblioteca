package com.twu.biblioteca;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<IUser> users;
    IUser loggedInUser;

    public UserDatabase(ArrayList<IUser> users, IUser loggedInUser) {
        this.users = users;
        this.loggedInUser = loggedInUser;
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
            if(user.hasCredentials(libraryNumber, password)) {
                loggedInUser = user;
                return user;
            }
        }
        return new NullUser();
    }
}
