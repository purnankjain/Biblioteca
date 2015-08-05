package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.NextViewHandler;

public class NullUserView implements IView {

    NextViewHandler nextViewHandler;

    public NullUserView(NextViewHandler nextViewHandler) {
        this.nextViewHandler = nextViewHandler;
    }

    @Override
    public IView renderView(IUser user) {
        System.out.println("Invalid credentials");
        return nextViewHandler.nextViewOnInvalidCredentials();
    }
}
