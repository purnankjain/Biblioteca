package com.twu.biblioteca.operations;


import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.Controller;
import com.twu.biblioteca.view.View;

public class QuitOperation implements Operation {

    @Override
    public void execute(View view) {
        System.exit(0);
    }

    @Override
    public IView nextView(LibrarianMenuView librarianMenuView) {
        return null;
    }

    @Override
    public IView nextView(Controller nextViewHandler, IUser user) {
        return nextViewHandler.nextViewOnSelection(this);
    }

}
