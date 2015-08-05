package com.twu.biblioteca.view;

import com.twu.biblioteca.IUser;
import com.twu.biblioteca.NextViewHandler;
import com.twu.biblioteca.operations.Operation;
import com.twu.biblioteca.parser.Parser;

public class UserMenuView implements IView {

    InputView inputView;
    Parser parser;
    NextViewHandler nextViewHandler;

    public UserMenuView(InputView inputView, Parser parser, NextViewHandler nextViewHandler) {
        this.inputView = inputView;
        this.parser = parser;
        this.nextViewHandler = nextViewHandler;
    }

    @Override
    public IView renderView(IUser user) {
        printUserMenu();
        String input = inputView.readInput();
        Operation operation = parser.selectOperation(input);
        return operation.nextView(nextViewHandler, user);
    }

    private void printUserMenu() {
        System.out.println("=======================");
        System.out.println("List Books");
        System.out.println("List Movies");
        System.out.println("CheckOut Book");
        System.out.println("CheckOut Movie");
        System.out.println("Return Book");
        System.out.println("Return Movie");
        System.out.println("Logout");
        System.out.println("Quit");
        System.out.println("=======================");
        System.out.println("Enter Choice : ");
    }
}
