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
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        MovieLibrary movieLibrary = new MovieLibrary(movieList, new ArrayList<Movie>());
        QuitOperation quitOperation = new QuitOperation("Quit");
        InvalidOperation invalidMenuOption = new InvalidOperation();
        ListBooksOperation listBooksOperation = new ListBooksOperation("List Books", bookLibrary);
        ArrayList<Operation> operations = new ArrayList<Operation>();
        operations.add(listBooksOperation);
        operations.add(new CheckOutMovieOperation("CheckOut Book", bookLibrary));
        operations.add(new ReturnBookOperation("Return Book", bookLibrary));
        operations.add(new ListMoviesOperation("List Movies", movieLibrary));
        operations.add(quitOperation);
        Menu menu = new Menu(operations, invalidMenuOption);
        bookList.add(book1);
        bookList.add(book2);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, menu);
        bibliotecaApplication.start();
    }
}
