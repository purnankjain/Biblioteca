package com.twu.biblioteca;


public class QuitOption implements MenuOption {
    private String name;

    public QuitOption(String name) {
        this.name = name;
    }

    @Override
    public void execute(View view) {
        System.exit(0);
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }
}
