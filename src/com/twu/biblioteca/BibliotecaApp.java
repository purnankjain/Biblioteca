package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        View view = new View();
        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("The Alchemist");
        bookList.add("Harry Potter And the Half Blood Prince");
        bookList.add("White Tiger");
        BookLibrary bookLibrary = new BookLibrary(bookList);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, bookLibrary);
        bibliotecaApplication.start();
    }
}
