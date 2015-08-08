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
    User loggedInUser;

    public Controller(LibrarianMenuView librarianMenuView, LoginView loginView,
                      NullUserView nullUserView, UserMenuView userMenuView,
                      WelcomeView welcomeView, HashMap<String, IView> operationHashMap,
                      User loggedInUser) {
        this.librarianMenuView = librarianMenuView;
        this.loginView = loginView;
        this.nullUserView = nullUserView;
        this.userMenuView = userMenuView;
        this.welcomeView = welcomeView;
        this.operationHashMap = operationHashMap;
        this.loggedInUser = loggedInUser;
    }

    public void execute() {
        IView iView = welcomeView;

        while(true) {
                iView = iView.renderView(this, loggedInUser);
        }
    }

    public IView menuView(User user) {
        this.loggedInUser = user;
        if(loggedInUser.hasRole(UserRoles.NULL_USER)) {
            return nullUserView;
        }
        if(loggedInUser.hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }

    public IView nextViewOnInvalidSelection() {
        if(loggedInUser.hasRole(UserRoles.NULL_USER)) {
            return loginView;
        }
        if(loggedInUser.hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }

    public IView nextViewOnInvalidCredentials() {
        return loginView;
    }

    public IView selectOperationView(String input) {
        try{
            IView view;
            if(operationHashMap.containsKey(input))
                view = operationHashMap.get(input);
            else
                view = operationHashMap.get(" ");

            return view;
        }
        catch (Exception e) {
            return operationHashMap.get(" ");
        }
    }

    public IView nextViewAfterLogOut() {
        return loginView;
    }
}
