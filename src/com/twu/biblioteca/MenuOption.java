package com.twu.biblioteca;


public interface MenuOption {
    void execute(View view);
    boolean nameEquals(String toCheck);
}
