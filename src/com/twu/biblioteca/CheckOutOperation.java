package com.twu.biblioteca;


public class CheckOutOperation implements Operation {
    String name;
    private Library library;

    public CheckOutOperation(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter name to checkout : \n");
        view.printToConsole(library.checkOutItem(view.readUserInput()));
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
