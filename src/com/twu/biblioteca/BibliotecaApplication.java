package com.twu.biblioteca;


import com.twu.biblioteca.user.User;
import com.twu.biblioteca.view.View;

public class BibliotecaApplication {
    View view;
    User loggedInUser;
    Controller controller;

    public BibliotecaApplication(View view, User loggedInUser, Controller controller) {
        this.view = view;
        this.loggedInUser = loggedInUser;
        this.controller = controller;
    }

    public void start() {
        controller.execute();
    }
}
