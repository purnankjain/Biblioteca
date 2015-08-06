package com.twu.biblioteca.user;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LoginView;

public interface IUser {
    IView nextViewAfterLogin(LoginView loginView);
    boolean hasCredentials(String libraryNumber, String password);
    IView nextViewAfterLogin(Controller nextViewHandler);
    IView nextViewOnInvalidSelection(Controller nextViewHandler);
}
