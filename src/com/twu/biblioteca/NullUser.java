package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public class NullUser implements IUser{

    @Override
    public IView nextView(LoginView loginView) {
        return loginView.nextView(this);
    }

    @Override
    public boolean hasCredentials(String libraryNumber, String password) {
        return false;
    }
}
