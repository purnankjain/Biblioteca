package com.twu.biblioteca;

public class CheckOutOption implements MenuOption {
    String name;
    private BookLibrary bookLibrary;

    public CheckOutOption(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute(View view) {
    }

    @Override
    public String toString() {
        return name;
    }

}
