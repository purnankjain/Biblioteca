package com.twu.biblioteca;


public class QuitOperation implements Operation {
    private String name;

    public QuitOperation(String name) {
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
