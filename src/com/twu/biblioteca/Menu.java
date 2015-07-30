package com.twu.biblioteca;


public class Menu {
    BookLibrary bookLibrary;
    QuitOption quitOption;
    InvalidMenuOption invalidMenuOption;

    public Menu(BookLibrary bookLibrary, QuitOption quitOption, InvalidMenuOption invalidMenuOption) {
        this.bookLibrary = bookLibrary;
        this.quitOption = quitOption;
        this.invalidMenuOption = invalidMenuOption;
    }

    public void renderMenu(View view) {
        view.printToConsole("===========================");
        view.printToConsole("List Books");
        view.printToConsole("Quit");
        view.printToConsole("===========================");
    }

    public MenuOption selectItem(String userInput) {
        if (userInput.equals("List Books")) {
            return bookLibrary;
        } else if (userInput.equals("Quit")) {
            return quitOption;
        }
        return invalidMenuOption;
    }
}
