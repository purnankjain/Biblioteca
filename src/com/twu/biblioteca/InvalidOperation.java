package com.twu.biblioteca;


public class InvalidOperation implements Operation {

    @Override
    public boolean execute(View view) {
        view.printToConsole("Select a valid option!");
        return true;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return false;
    }
}
