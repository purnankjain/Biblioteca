package com.twu.biblioteca;

public class QuitOption implements MenuOption {
    @Override
    public void execute(View view) {
        System.exit(0);
    }

}
