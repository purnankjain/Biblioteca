package com.twu.biblioteca;


import com.twu.biblioteca.operations.Operation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.user.IUser;
import com.twu.biblioteca.view.View;

public class BibliotecaApplication {
    View view;
    Parser parser;
    IUser loggedInUser;

    public BibliotecaApplication(View view, Parser parser, IUser loggedInUser) {
        this.view = view;
        this.parser = parser;
        this.loggedInUser = loggedInUser;
    }

    public void start() {
        view.greetUser();
        Operation operation;
        String input;
        while(true) {
            view.printMenu();
            input = view.readUserInput();
            operation = parser.selectOperation(input);
            operation.execute(view);
        }
    }
}
