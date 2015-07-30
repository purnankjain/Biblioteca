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
        view.printToConsole("Enter book to checkout : \n");
        view.printToConsole(bookLibrary.checkOutItem(view.readUserInput()));
    }

    @Override
    public String toString() {
        return name;
    }

}
