package com.twu.biblioteca;


public class Menu {
    BookLibrary bookLibrary;
    Quit quit;
    InvalidMenuItem invalidMenuItem;

    public Menu(BookLibrary bookLibrary, Quit quit, InvalidMenuItem invalidMenuItem) {
        this.bookLibrary = bookLibrary;
        this.quit = quit;
        this.invalidMenuItem = invalidMenuItem;
    }

    public void renderMenu(View view) {
        view.printToConsole("===========================");
        view.printToConsole("List Books");
        view.printToConsole("Quit");
        view.printToConsole("===========================");
    }

    public MenuItem selectItem(String userInput) {
        if (userInput.equals("List Books")) {
            return bookLibrary;
        } else if (userInput.equals("Quit")) {
            return quit;
        }
        return invalidMenuItem;
    }
}
