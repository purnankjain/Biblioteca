package com.twu.biblioteca;


public class BibliotecaApplication {
    View view;
    Menu menu;

    public BibliotecaApplication(View view, Menu menu) {
        this.view = view;
        this.menu = menu;
    }

    public void start() {
        view.greetUser();
        Operation operation;
        String input;
        boolean runLoop = true;
        while(runLoop) {
            view.printToConsole(menu);
            input = view.readUserInput();
            operation = menu.selectItem(input);
            runLoop = operation.execute(view);
        }
    }
}
