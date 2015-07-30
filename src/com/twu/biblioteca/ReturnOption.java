package com.twu.biblioteca;

public class ReturnOption implements MenuOption {
    private String name;
    private BookLibrary bookLibrary;

    public ReturnOption(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void execute(View view) {

    }
}
