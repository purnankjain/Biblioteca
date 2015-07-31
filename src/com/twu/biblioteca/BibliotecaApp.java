package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BibliotecaApp {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        View view = new View(bufferedReader);
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Harry Potter", "J.K Rowling", 2005);
        BookLibrary bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());
        QuitOption quitOption = new QuitOption("Quit");
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption();
        ListBooksOption listBooksOption = new ListBooksOption("List Books", bookLibrary);
        ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(listBooksOption);
        menuOptions.add(new CheckOutOption("CheckOut Book", bookLibrary));
        menuOptions.add(new ReturnOption("Return Book", bookLibrary));
        menuOptions.add(quitOption);
        Menu menu = new Menu(menuOptions, invalidMenuOption);
        bookList.add(book1);
        bookList.add(book2);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, menu);
        bibliotecaApplication.start();
    }
}
