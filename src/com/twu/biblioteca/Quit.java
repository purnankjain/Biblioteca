package com.twu.biblioteca;

public class Quit implements MenuItem {
    @Override
    public void execute() {
        System.exit(0);
    }
}
