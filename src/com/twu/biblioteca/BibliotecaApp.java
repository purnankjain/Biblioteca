package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class BibliotecaApp {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        View view = new View(bufferedReader);


        ArrayList<Item> bookList = new ArrayList<Item>();
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book book2 = new Book("Harry Potter", "J.K Rowling", 2005);
        bookList.add(book1);
        bookList.add(book2);
        Library bookLibrary = new Library("Book", bookList, new ArrayList<Item>());

        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        movieList.add(new Movie("Dave", 2005, "blah", "unrated"));
        Library movieLibrary = new Library("Movie", movieList, new ArrayList<Item>());


        QuitOperation quitOperation = new QuitOperation("Quit");
        InvalidOperation invalidMenuOption = new InvalidOperation();
        ListOperation listOperation = new ListOperation("List Books", bookLibrary);
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(listOperation);
        operations.add(new CheckOutOperation("CheckOut Book", bookLibrary));
        operations.add(new ReturnItemOperation("Return Book", bookLibrary));

        operations.add(new ListOperation("List Movies", movieLibrary));
        operations.add(new CheckOutOperation("CheckOut Movie", movieLibrary));

        operations.add(quitOperation);
        Menu menu = new Menu(operations, invalidMenuOption);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, menu);
        bibliotecaApplication.start();
    }
}
