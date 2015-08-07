package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class InvalidOperationView implements IView {

    Controller nextViewHandler;

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println("Invalid selection");
        return user.nextViewOnInvalidSelection(nextViewHandler);
    }
}
