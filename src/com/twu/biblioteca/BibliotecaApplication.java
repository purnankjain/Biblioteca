package com.twu.biblioteca;


public class BibliotecaApplication {
    Controller controller;

    public BibliotecaApplication(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        controller.execute();
    }
}
