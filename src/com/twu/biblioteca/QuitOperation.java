package com.twu.biblioteca;


public class QuitOperation implements Operation {
    private String name;

    public QuitOperation(String name) {
        this.name = name;
    }

    @Override
    public boolean execute(View view) {
        return false;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    public String getName() {
        return name;
    }
}
