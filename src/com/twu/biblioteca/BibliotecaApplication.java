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
        MenuOption menuOption;
        String input;
        while(true) {
            view.printToConsole(menu.renderMenu());
            input = view.readUserInput();
            menuOption = menu.selectItem(input);
            menuOption.execute(view);
        }
    }
}
