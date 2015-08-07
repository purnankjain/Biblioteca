package com.twu.biblioteca;


import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.View;

public class BibliotecaApplication {
    View view;
    User loggedInUser;

    public BibliotecaApplication(View view, User loggedInUser) {
        this.view = view;
        this.loggedInUser = loggedInUser;
    }

    public void start() {
        view.greetUser();
        String input;
        while(true) {
            view.printMenu();
            input = view.readUserInput();
        }
    }
}
