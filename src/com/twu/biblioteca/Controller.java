package com.twu.biblioteca;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserRoles;
import com.twu.biblioteca.view.*;

import java.util.HashMap;

public class Controller {
    LibrarianMenuView librarianMenuView;
    LoginView loginView;
    NullUserView nullUserView;
    UserMenuView userMenuView;
    WelcomeView welcomeView;
    HashMap<String, IView> operationHashMap;

    public Controller(LibrarianMenuView librarianMenuView, LoginView loginView,
                      NullUserView nullUserView, UserMenuView userMenuView,
                      WelcomeView welcomeView, HashMap operationHashMap) {
        this.librarianMenuView = librarianMenuView;
        this.loginView = loginView;
        this.nullUserView = nullUserView;
        this.userMenuView = userMenuView;
        this.welcomeView = welcomeView;
        this.operationHashMap = operationHashMap;
    }

    public void foo(User user) {
        IView iView = welcomeView;

        while(true) {
                iView = iView.renderView(this, user);
        }
    }

    public IView nextViewAfterLogin(User user) {
        if(user.hasRole(UserRoles.NULL_USER)) {
            return nullUserView;
        }
        if(user.hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }

    public IView nextViewOnInvalidSelection(User user) {
        if(user.hasRole(UserRoles.NULL_USER)) {
            return loginView;
        }
        if(user.hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }

    public IView nextViewOnInvalidCredentials() {
        return loginView;
    }

    public IView selectOperationView(String input, User user) {
        try{
            return operationHashMap.get(input);
        }
        catch (Exception e) {
            return operationHashMap.get("");
        }
    }
}
