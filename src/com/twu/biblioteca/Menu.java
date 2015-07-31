package com.twu.biblioteca;

import java.util.ArrayList;


public class Menu {
    ArrayList<MenuOption> menuOptions;
    InvalidMenuOption invalidMenuOption;

    public Menu(ArrayList<MenuOption> menuOptions, InvalidMenuOption invalidMenuOption) {
        this.menuOptions = menuOptions;
        this.invalidMenuOption = invalidMenuOption;
    }

    public String renderMenu() {
        String menu = "";
        menu += "=========================\n";
        menu += "          Menu\n";
        menu += "=========================\n";
        menu += "List Books\n";
        menu += "CheckOut Book\n";
        menu += "Return Book\n";
        menu += "Quit\n";
        menu += "=========================\n\n";
        menu += "Enter Choice : ";
        return menu;
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
