package com.twu.biblioteca.operations;


import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.view.View;

public class ReturnItemOperation implements Operation {
    private LibrarySection librarySection;

    public ReturnItemOperation(LibrarySection librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public void execute(View view) {
        view.printToConsole("Enter item to Return : \n");
        view.printToConsole(librarySection.returnThisItem(view.readUserInput()));
    }
}
