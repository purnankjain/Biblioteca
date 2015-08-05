package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.NullUser;
import com.twu.biblioteca.User;
import com.twu.biblioteca.UserRoles;

public class NextViewHandler {
    InvalidOperationView invalidOperationView;
    LibrarianMenuView librarianMenuView;
    ListView listView;
    LoginView loginView;
    NullUserView nullUserView;
    ReturnView returnView;
    UserMenuView userMenuView;

    public NextViewHandler(InvalidOperationView invalidOperationView, LibrarianMenuView librarianMenuView,
                           ListView listView, LoginView loginView, NullUserView nullUserView,
                           ReturnView returnView, UserMenuView userMenuView) {
        this.invalidOperationView = invalidOperationView;
        this.librarianMenuView = librarianMenuView;
        this.listView = listView;
        this.loginView = loginView;
        this.nullUserView = nullUserView;
        this.returnView = returnView;
        this.userMenuView = userMenuView;
    }

    public IView nextViewAfterLogin(NullUser nullUser) {
        return nullUserView;
    }

    public IView nextViewAfterLogin(IUser user) {
        if(((User)user).hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }
}
