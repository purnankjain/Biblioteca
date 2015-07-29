package com.twu.biblioteca;


public class Menu {
    BookLibrary bookLibrary;
    Quit quit;

    public Menu(BookLibrary bookLibrary, Quit quit) {
        this.bookLibrary = bookLibrary;
        this.quit = quit;
    }

    public void renderMenu(View view) {
        view.printToConsole("===========================");
        view.printToConsole("List Books");
        view.printToConsole("===========================");
    }

    public MenuItem selectItem(String userInput) {
        if (userInput.equals("List Books")) {
            return bookLibrary;
        } else if (userInput.equals("Quit")) {
            return quit;
        }
        return null;
    }
}
