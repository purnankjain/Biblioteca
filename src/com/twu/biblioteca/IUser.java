package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public interface IUser {
    IView nextView(LoginView loginView);
    boolean hasCredentials(String libraryNumber, String password);
}
