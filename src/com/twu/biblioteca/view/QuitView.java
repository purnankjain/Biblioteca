package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class QuitView implements IView{
    @Override
    public IView renderView(Controller controller, User user) {
        System.exit(0);
        return null;
    }
}
