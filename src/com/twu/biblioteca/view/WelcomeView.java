package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;

public class WelcomeView implements IView {

    LoginView loginView;

    public WelcomeView(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public IView renderView(IUser user) {
        System.out.println("--WELCOME TO BIBLIOTECA--");
        return loginView;
    }
}
