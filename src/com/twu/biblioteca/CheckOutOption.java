package com.twu.biblioteca;

public class CheckOutOption implements MenuOption {
    String name;

    public CheckOutOption(String name) {
        this.name = name;
    }

    @Override
    public void execute(View view) {
    }

    @Override
    public String toString() {
        return name;
    }

}
