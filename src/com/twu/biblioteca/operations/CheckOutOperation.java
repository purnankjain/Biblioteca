package com.twu.biblioteca.operations;


import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class CheckOutOperation implements Operation {
    private Library library;

    public CheckOutOperation(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter name to checkout : \n");
        view.printToConsole(library.checkOutItem(view.readUserInput()));
        return true;
    }
}
