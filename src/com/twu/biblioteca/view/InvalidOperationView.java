package com.twu.biblioteca.view;

import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.Controller;

public class InvalidOperationView implements IView {

    Controller nextViewHandler;

    @Override
    public IView renderView(IUser user) {
        System.out.println("Invalid selection");
        return user.nextViewOnInvalidSelection(nextViewHandler);
    }
}
