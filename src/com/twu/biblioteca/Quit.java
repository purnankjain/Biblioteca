package com.twu.biblioteca;

public class Quit implements MenuItem {
    @Override
    public void execute(View view) {
        System.exit(0);
    }

    @Override
    public String checkOutItem(String item) {
        return null;
    }
}
