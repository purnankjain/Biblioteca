package com.twu.biblioteca;


public class CheckOutOperation implements Operation {
    String name;
    private BookLibrary bookLibrary;

    public CheckOutOperation(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute(View view) {
        view.printToConsole("Enter book to checkout : \n");
        view.printToConsole(bookLibrary.checkOutItem(view.readUserInput()));
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }
}
