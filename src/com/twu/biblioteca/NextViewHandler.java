package com.twu.biblioteca;

import com.twu.biblioteca.operations.CheckOutOperation;
import com.twu.biblioteca.operations.ListOperation;
import com.twu.biblioteca.operations.QuitOperation;
import com.twu.biblioteca.operations.ReturnItemOperation;
import com.twu.biblioteca.view.*;

public class NextViewHandler {
    InvalidOperationView invalidOperationView;
    LibrarianMenuView librarianMenuView;
    ListView listView;
    LoginView loginView;
    NullUserView nullUserView;
    ReturnView returnView;
    UserMenuView userMenuView;
    CheckOutView checkOutView;
    QuitView quitView;

    public NextViewHandler(InvalidOperationView invalidOperationView, LibrarianMenuView librarianMenuView,
                           ListView listView, LoginView loginView, NullUserView nullUserView,
                           ReturnView returnView, UserMenuView userMenuView, CheckOutView checkOutView,
                           QuitView quitView) {
        this.invalidOperationView = invalidOperationView;
        this.librarianMenuView = librarianMenuView;
        this.listView = listView;
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
        return listView;
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
}
