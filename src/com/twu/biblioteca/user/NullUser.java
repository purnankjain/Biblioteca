package com.twu.biblioteca.user;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public class NullUser implements IUser{

    @Override
    public IView nextViewAfterLogin(LoginView loginView) {
        return null;
    }

    @Override
    public boolean hasCredentials(String libraryNumber, String password) {
        return false;
    }

    @Override
    public IView nextViewAfterLogin(Controller nextViewHandler) {
        return nextViewHandler.nextViewAfterLogin(this);
    }

    @Override
    public IView nextViewOnInvalidSelection(Controller nextViewHandler) {
        return nextViewHandler.nextViewOnInvalidSelection(this);
    }
}
