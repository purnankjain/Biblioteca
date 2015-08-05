package com.twu.biblioteca.operations;


import com.twu.biblioteca.IUser;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.NextViewHandler;
import com.twu.biblioteca.view.View;

public class InvalidOperation implements Operation {

    @Override
    public void execute(View view) {
        view.printToConsole("Select a valid option!");
    }

    @Override
    public IView nextView(LibrarianMenuView librarianMenuView) {
        return null;
    }

    @Override
    public IView nextView(NextViewHandler nextViewHandler, IUser user) {
        return nextViewHandler.nextViewOnSelection();
    }
}
