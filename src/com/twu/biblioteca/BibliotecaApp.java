package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        View view = new View(bufferedReader);
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("The Alchemist", "Poelo Coehlo", 2005);
        Book book2 = new Book("Harry Potter And the Half Blood Prince", "J.K Rowling", 2005);
        BookLibrary bookLibrary = new BookLibrary(bookList);
        QuitOption quitOption = new QuitOption();
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
        ListBooksOption listBooksOption = new ListBooksOption(bookLibrary);
        Menu menu = new Menu(listBooksOption, quitOption, invalidMenuOption);
        bookList.add(book1);
        bookList.add(book2);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, menu);
        bibliotecaApplication.start();
    }
}
