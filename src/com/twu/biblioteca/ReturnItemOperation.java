package com.twu.biblioteca;


public class ReturnItemOperation implements Operation {
    private String name;
    private Library library;

    public ReturnItemOperation(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole("Enter item to Return : \n");
        view.printToConsole(library.returnThisItem(view.readUserInput()));
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
