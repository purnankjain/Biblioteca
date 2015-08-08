package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;

public class LoginView implements IView {

    InputView inputView;
    UserDatabase userDatabase;

    public LoginView(InputView inputView, UserDatabase userDatabase) {
        this.inputView = inputView;
        this.userDatabase = userDatabase;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        user = loginUser();
        return user.menuView(controller);
    }

    private User loginUser() {
        System.out.println("Enter Library Number : ");
        String libraryNumber = inputView.readInput();
        System.out.println("Enter password : ");
        String password = inputView.readInput();

        return userDatabase.login(libraryNumber, password);
    }
}