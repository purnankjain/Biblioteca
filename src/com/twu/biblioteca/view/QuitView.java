package com.twu.biblioteca.view;

import com.twu.biblioteca.user.IUser;

public class QuitView implements IView{
    @Override
    public IView renderView(IUser user) {
        System.exit(0);
        return null;
    }
}
