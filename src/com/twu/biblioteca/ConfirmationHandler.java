package com.twu.biblioteca;

import com.twu.biblioteca.view.View;

public class ConfirmationHandler {
    View view;

    public ConfirmationHandler(View view) {
        this.view = view;
    }

    public boolean validateCheckOut(String item, boolean success) {
        if(success) {
            confirmSuccessfulCheckOutToUser(item);
        }
        else {
            confirmUnsuccessfulCheckOut(item);
        }
        return success;
    }

    private void confirmUnsuccessfulCheckOut(String item) {
        view.printToConsole("That " + item + " is not available.");
    }

    private void confirmSuccessfulCheckOutToUser(String item) {
        view.printToConsole("Thank you! Enjoy the " + item + ".");
    }
}
