package com.twu.biblioteca.view;

import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.Controller;

public class NullUserView implements IView {

    Controller nextViewHandler;

    public NullUserView(Controller nextViewHandler) {
        this.nextViewHandler = nextViewHandler;
    }

    @Override
    public IView renderView(IUser user) {
        System.out.println("Invalid credentials");
        return nextViewHandler.nextViewOnInvalidCredentials();
    }
}
