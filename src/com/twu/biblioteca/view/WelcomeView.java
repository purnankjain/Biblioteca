package com.twu.biblioteca.view;

import com.twu.biblioteca.User;

public class WelcomeView implements IView {

    LoginView loginView;

    public WelcomeView(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public IView renderView(User user) {
        System.out.println("--WELCOME TO BIBLIOTECA--");
        return loginView;
    }
}
