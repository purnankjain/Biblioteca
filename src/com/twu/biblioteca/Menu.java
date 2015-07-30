package com.twu.biblioteca;


public class Menu {
    ListBooksOption listBooksOption;
    QuitOption quitOption;
    InvalidMenuOption invalidMenuOption;

    public Menu(ListBooksOption listBooksOption, QuitOption quitOption, InvalidMenuOption invalidMenuOption) {
        this.listBooksOption = listBooksOption;
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
            return listBooksOption;
        } else if (userInput.equals("Quit")) {
            return quitOption;
        }
        return invalidMenuOption;
    }
}
