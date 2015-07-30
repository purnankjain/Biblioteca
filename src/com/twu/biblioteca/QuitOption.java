package com.twu.biblioteca;

public class QuitOption implements MenuOption {
    @Override
    public void execute(View view) {
        System.exit(0);
    }

    @Override
    public String checkOutItem(String item) {
        return null;
    }
}
