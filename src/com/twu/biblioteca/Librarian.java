package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public class Librarian implements IUser{

    String libraryNumber;
    String password;

    public Librarian(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (libraryNumber.equals(thatId) && password.equals(thatPassword));
    }

    @Override
    public IView nextView(LoginView loginView) {
        return loginView.nextView(this);
    }
}
