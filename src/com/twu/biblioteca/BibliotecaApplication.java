package com.twu.biblioteca;


import com.twu.biblioteca.operations.Operation;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.view.View;

public class BibliotecaApplication {
    View view;
    Parser parser;

    public BibliotecaApplication(View view, Parser parser) {
        this.view = view;
        this.parser = parser;
    }

    public void start() {
        view.greetUser();
        Operation operation;
        String input;
        boolean runLoop = true;
        while(runLoop) {
            view.printMenu();
            input = view.readUserInput();
            operation = parser.selectOperation(input);
            runLoop = operation.execute(view);
        }
    }
}
