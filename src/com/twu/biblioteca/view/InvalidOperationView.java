package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.NextViewHandler;

public class InvalidOperationView implements IView {

    NextViewHandler nextViewHandler;

    @Override
    public IView renderView(IUser user) {
        System.out.println("Invalid selection");
        return user.nextViewOnInvalidSelection(nextViewHandler);
    }
}
