package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class NullUserView implements IView {

    String invalidCredentials;

    public NullUserView(String invalidCredentials) {
        this.invalidCredentials = invalidCredentials;
        this.invalidCredentials = "Invalid credentials";
    }

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println(invalidCredentials);
        return controller.nextViewOnInvalidCredentials();
    }
}
