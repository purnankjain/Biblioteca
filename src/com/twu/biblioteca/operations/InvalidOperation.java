package com.twu.biblioteca.operations;


import com.twu.biblioteca.view.View;

public class InvalidOperation implements Operation {

    @Override
    public boolean execute(View view) {
        view.printToConsole("Select a valid option!");
        return true;
    }
}
