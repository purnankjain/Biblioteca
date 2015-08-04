package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.User;
import com.twu.biblioteca.UserDatabase;

import java.io.BufferedReader;

public class LoginView implements IView {

    BufferedReader bufferedReader;
    UserDatabase userDatabase;
    IUser user;

    public LoginView(BufferedReader bufferedReader, UserDatabase userDatabase) {
        this.bufferedReader = bufferedReader;
        this.userDatabase = userDatabase;
    }

    @Override
    public IView renderView(User user) {
        return null;
    }

    private String readInput() {
        try {
            return bufferedReader.readLine();
        }
        catch(Exception e) {

        }
        return "";
    }
}
