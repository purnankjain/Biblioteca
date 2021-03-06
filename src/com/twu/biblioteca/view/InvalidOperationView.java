package com.twu.biblioteca.view;

import com.twu.biblioteca.Controller;
import com.twu.biblioteca.user.User;

public class InvalidOperationView implements IView {

    String invalidMessage;

    public InvalidOperationView(String invalid) {
        invalidMessage = invalid;
    }

    @Override
    public IView renderView(Controller controller, User user) {
        System.out.println(invalidMessage);
        return user.nextViewOnInvalidSelection(controller);
    }
}
