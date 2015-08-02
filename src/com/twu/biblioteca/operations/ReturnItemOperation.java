package com.twu.biblioteca.operations;


import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class ReturnItemOperation implements Operation {
    private Library library;

    public ReturnItemOperation(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter item to Return : \n");
        view.printToConsole(library.returnThisItem(view.readUserInput()));
        return true;
    }
}
