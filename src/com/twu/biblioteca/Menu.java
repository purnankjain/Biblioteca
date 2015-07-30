package com.twu.biblioteca;


import java.util.ArrayList;

public class Menu {
    ArrayList<MenuOption> menuOptions;
    InvalidMenuOption invalidMenuOption;

    public Menu(ArrayList<MenuOption> menuOptions, InvalidMenuOption invalidMenuOption) {
        this.menuOptions = menuOptions;
        this.invalidMenuOption = invalidMenuOption;
    }

    public void renderMenu(View view) {
        view.printToConsole("===========================");
        view.printToConsole("List Books");
        view.printToConsole("Quit");
        view.printToConsole("===========================");
    }

    public MenuOption selectItem(String userInput) {
        String name;
        for(MenuOption option : menuOptions) {
            name = option.toString();
            if(name.equals(userInput))
                return option;
        }
        return invalidMenuOption;
    }
}
