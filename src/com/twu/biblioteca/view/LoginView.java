package com.twu.biblioteca.view;

import com.twu.biblioteca.*;

public class LoginView implements IView {

    InputView inputView;
    UserDatabase userDatabase;
    LibrarianMenuView librarianMenuView;
    UserMenuView userMenuView;
    NullUserView nullUserView;

    public LoginView(InputView inputView, UserDatabase userDatabase, LibrarianMenuView librarianMenuView,
                     UserMenuView userMenuView, NullUserView nullUserView) {
        this.inputView = inputView;
        this.userDatabase = userDatabase;
        this.librarianMenuView = librarianMenuView;
        this.userMenuView = userMenuView;
        this.nullUserView = nullUserView;
    }

    @Override
    public IView renderView(IUser user) {
        user = loginUser();
        return user.nextView(this);
    }

    private IUser loginUser() {
        System.out.println("Enter Library Number : ");
        String libraryNumber = inputView.readInput();
        System.out.println("Enter password : ");
        String password = inputView.readInput();

        return userDatabase.login(libraryNumber, password);
    }

    public IView nextView(Librarian librarian) {
        return librarianMenuView;
    }

    public IView nextView(User user) {
        return userMenuView;
    }

    public IView nextView(NullUser nullUser) {
        return nullUserView;
    }

}
