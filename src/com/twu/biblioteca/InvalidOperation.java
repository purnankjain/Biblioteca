package com.twu.biblioteca;


public class InvalidOperation implements Operation {

    @Override
    public void execute(View view) {
        view.printToConsole("Select a valid option!");
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return false;
    }
}
