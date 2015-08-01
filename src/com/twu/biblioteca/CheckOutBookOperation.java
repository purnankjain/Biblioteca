package com.twu.biblioteca;


public class CheckOutBookOperation implements Operation {
    String name;
    private BookLibrary bookLibrary;

    public CheckOutBookOperation(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter book to checkout : \n");
        view.printToConsole(bookLibrary.checkOutItem(view.readUserInput()));
        return true;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    public String getName() {
        return name;
    }
}
