package com.twu.biblioteca;


public class ReturnBookOperation implements Operation {
    private String name;
    private BookLibrary bookLibrary;

    public ReturnBookOperation(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter book to Return : \n");
        view.printToConsole(bookLibrary.returnThisItem(view.readUserInput()));
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
