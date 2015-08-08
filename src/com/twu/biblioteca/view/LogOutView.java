package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;

public class LogOutView implements IView {
    UserDatabase userDatabase;

    public LogOutView(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        user = userDatabase.logout();
        return controller.nextViewAfterLogOut();
    }
}
