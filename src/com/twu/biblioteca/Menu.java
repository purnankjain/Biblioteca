package com.twu.biblioteca;

import java.util.ArrayList;


public class Menu {
    ArrayList<Operation> operations;
    InvalidOperation invalidMenuOption;

    public Menu(ArrayList<Operation> operations, InvalidOperation invalidMenuOption) {
        this.operations = operations;
        this.invalidMenuOption = invalidMenuOption;
    }

    @Override
    public String toString() {
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

    public Operation selectItem(String userInput) {
        for(Operation option : operations) {
            if(option.nameEquals(userInput))
                return option;
        }
        return invalidMenuOption;
    }
}
