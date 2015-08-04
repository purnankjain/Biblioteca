package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public class NullUser implements IUser{

    @Override
    public boolean hasCredentials(String thatId, String thatPassword) {
        return false;
    }

    @Override
    public IView nextView(LoginView loginView) {
        return loginView.nextView(this);
    }
}
