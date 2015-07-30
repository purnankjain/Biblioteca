package com.twu.biblioteca;

public class InvalidMenuOption implements MenuOption {

    @Override
    public void execute(View view) {
        view.printToConsole("Select a valid option!");
    }
}
