package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        View view = new View();
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book(1, "The Alchemist", "Poelo Coehlo", 2005);
        Book book2 = new Book(2, "Harry Potter And the Half Blood Prince", "J.K Rowling", 2005);
        Menu menu = new Menu();
        bookList.add(book1);
        bookList.add(book2);
        BookLibrary bookLibrary = new BookLibrary(bookList);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, bookLibrary, menu);
        bibliotecaApplication.start();
    }
}
