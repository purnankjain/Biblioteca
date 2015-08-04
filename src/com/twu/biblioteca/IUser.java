package com.twu.biblioteca;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public interface IUser {
    boolean hasCredentials(String thatId, String thatPassword);

    IView nextView(LoginView loginView);
}
