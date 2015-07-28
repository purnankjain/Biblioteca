package com.twu.biblioteca;


public class BibliotecaApplication {
    View view;
    BookLibrary bookLibrary;

    public BibliotecaApplication(View view, BookLibrary bookLibrary) {
        this.view = view;
        this.bookLibrary = bookLibrary;
    }

    public void start() {
        view.greetUser();
        view.printBookNamesToConsole(bookLibrary.getAllBooks());
    }
}
