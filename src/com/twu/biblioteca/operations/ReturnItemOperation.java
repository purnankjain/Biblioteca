package com.twu.biblioteca.operations;


import com.twu.biblioteca.ConfirmationHandler;
import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.LibrarianMenuView;
import com.twu.biblioteca.Controller;
import com.twu.biblioteca.view.View;

public class ReturnItemOperation implements Operation {
    private String item;
    private LibrarySection librarySection;
    private ConfirmationHandler confirmationHandler;

    public ReturnItemOperation(String item, LibrarySection librarySection, ConfirmationHandler confirmationHandler) {
        this.item = item;
        this.librarySection = librarySection;
        this.confirmationHandler = confirmationHandler;
    }

    @Override
    public void execute(View view) {
        view.printToConsole("Enter " + item + " to Return : \n");
        confirmationHandler.validateReturn(item, librarySection.returnThisItem(view.readUserInput()));
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
