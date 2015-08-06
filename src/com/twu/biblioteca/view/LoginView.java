package com.twu.biblioteca.view;

import com.twu.biblioteca.*;
import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.user.UserDatabase;

public class LoginView implements IView {

    InputView inputView;
    UserDatabase userDatabase;
    Controller nextViewHandler;

    public LoginView(InputView inputView, UserDatabase userDatabase, Controller nextViewHandler) {
        this.inputView = inputView;
        this.userDatabase = userDatabase;
        this.nextViewHandler = nextViewHandler;
    }

    @Override
    public IView renderView(IUser user) {
        user = loginUser();
        return user.nextViewAfterLogin(nextViewHandler);
    }

    private IUser loginUser() {
        System.out.println("Enter Library Number : ");
        String libraryNumber = inputView.readInput();
        System.out.println("Enter password : ");
        String password = inputView.readInput();

        return userDatabase.login(libraryNumber, password);
    }
}
