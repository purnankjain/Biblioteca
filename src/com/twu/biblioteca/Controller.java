package com.twu.biblioteca;

import com.twu.biblioteca.operations.CheckOutOperation;
import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.operations.QuitOperation;
import com.twu.biblioteca.operations.ReturnItemOperation;
import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.user.NullUser;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserRoles;
import com.twu.biblioteca.view.*;

public class Controller {
    InvalidOperationView invalidOperationView;
    LibrarianMenuView librarianMenuView;
    ListAvailableItemsView listAvailableItemsView;
    LoginView loginView;
    NullUserView nullUserView;
    ReturnView returnView;
    UserMenuView userMenuView;
    CheckOutView checkOutView;
    QuitView quitView;

    public Controller(InvalidOperationView invalidOperationView, LibrarianMenuView librarianMenuView,
                      ListAvailableItemsView listAvailableItemsView, LoginView loginView, NullUserView nullUserView,
                      ReturnView returnView, UserMenuView userMenuView, CheckOutView checkOutView,
                      QuitView quitView) {
        this.invalidOperationView = invalidOperationView;
        this.librarianMenuView = librarianMenuView;
        this.listAvailableItemsView = listAvailableItemsView;
        this.loginView = loginView;
        this.nullUserView = nullUserView;
        this.returnView = returnView;
        this.userMenuView = userMenuView;
        this.checkOutView = checkOutView;
        this.quitView = quitView;
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

    public IView nextViewOnSelection(ListOperation listOperation) {
        return listAvailableItemsView;
    }

    public IView nextViewOnSelection(CheckOutOperation checkOutOperation) {
        return checkOutView ;
    }


    public IView nextViewOnSelection() {
        return invalidOperationView;
    }

    public IView nextViewOnSelection(QuitOperation quitOperation) {
        return quitView;
    }

    public IView nextViewOnSelection(ReturnItemOperation returnItemOperation) {
        return returnView;
    }

    public IView nextViewOnInvalidSelection(NullUser nullUser) {
        return loginView;
    }

    public IView nextViewOnInvalidSelection(User user) {
        if(user.hasRole(UserRoles.ADMIN_ROLE)) {
            return librarianMenuView;
        }
        return userMenuView;
    }

    public IView nextViewOnInvalidCredentials() {
        return loginView;
    }
}
