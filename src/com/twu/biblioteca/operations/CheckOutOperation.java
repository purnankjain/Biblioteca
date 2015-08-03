package com.twu.biblioteca.operations;


import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.view.View;

public class CheckOutOperation implements Operation {
    private LibrarySection librarySection;

    public CheckOutOperation(LibrarySection librarySection) {
        this.librarySection = librarySection;
    }

    @Override
    public void execute(View view) {
        view.printToConsole("Enter name to checkout : \n");
        view.printToConsole(librarySection.checkOutItem(view.readUserInput()));
    }
}
