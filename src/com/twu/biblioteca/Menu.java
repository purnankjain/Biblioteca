package com.twu.biblioteca;


public class Menu {
        BookLibrary bookLibrary;

    public Menu(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public void renderMenu(View view) {
        view.printToConsole("===========================");
        view.printToConsole("Book List");
        view.printToConsole("===========================");
    }

    public BookLibrary selectItem(String userInput) {
        return bookLibrary;
    }
}
