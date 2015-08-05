package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.NextViewHandler;
import com.twu.biblioteca.operations.*;
import com.twu.biblioteca.parser.Parser;

public class LibrarianMenuView implements IView{

    InputView inputView;
    Parser parser;
    NextViewHandler nextViewHandler;

    public LibrarianMenuView(InputView inputView, Parser parser, NextViewHandler nextViewHandler) {
        this.inputView = inputView;
        this.parser = parser;
        this.nextViewHandler = nextViewHandler;
    }

    @Override
    public IView renderView(IUser user) {
        printLibrarianMenu();
        String input = inputView.readInput();
        Operation operation = parser.selectOperation(input);
        return operation.nextView(nextViewHandler, user);
    }

    private void printLibrarianMenu() {
        System.out.println("=======================");
        System.out.println("List Books");
        System.out.println("List Movies");
        System.out.println("List CheckedOut Books");
        System.out.println("List CheckedOut Movies");
        System.out.println("CheckOut Book");
        System.out.println("CheckOut Movie");
        System.out.println("Return Book");
        System.out.println("Return Movie");
        System.out.println("=======================");
        System.out.println("Enter Choice : ");
    }
}
