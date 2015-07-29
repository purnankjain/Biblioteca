package com.twu.biblioteca;


public class BibliotecaApplication {
    View view;
    BookLibrary bookLibrary;
    Menu menu;

    public BibliotecaApplication(View view, BookLibrary bookLibrary, Menu menu) {
        this.view = view;
        this.bookLibrary = bookLibrary;
        this.menu = menu;
    }

    public void start() {
        view.greetUser();
        menu.renderMenu(view);
        view.printBookNamesToConsole(bookLibrary.getAllBooks());
    }
}
