package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;
import com.twu.biblioteca.view.NextViewHandler;

public class NullUser implements IUser{

    @Override
    public IView nextView(LoginView loginView) {
        return null;
    }

    @Override
    public boolean hasCredentials(String libraryNumber, String password) {
        return false;
    }

    @Override
    public IView nextView(NextViewHandler nextViewHandler) {
        return nextViewHandler.nextViewAfterLogin(this);
    }
}
