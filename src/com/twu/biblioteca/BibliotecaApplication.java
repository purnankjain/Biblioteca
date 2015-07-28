package com.twu.biblioteca;


public class BibliotecaApplication {
    View view;

    public BibliotecaApplication(View view) {
        this.view = view;
    }

    public void start() {
        view.greetUser();
    }
}
