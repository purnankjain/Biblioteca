package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        View view = new View(bufferedReader);
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book(1, "The Alchemist", "Poelo Coehlo", 2005);
        Book book2 = new Book(2, "Harry Potter And the Half Blood Prince", "J.K Rowling", 2005);
        BookLibrary bookLibrary = new BookLibrary(bookList);
        Quit quit = new Quit();
        InvalidMenuItem invalidMenuItem = new InvalidMenuItem();
        Menu menu = new Menu(bookLibrary, quit, invalidMenuItem);
        bookList.add(book1);
        bookList.add(book2);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, menu);
        bibliotecaApplication.start();
    }
}
