package com.twu.biblioteca.main;

import com.twu.biblioteca.*;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.parser.Parser;
import com.twu.biblioteca.view.View;

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
        LibrarySection bookLibrarySection = new LibrarySection("Book", bookList, new ArrayList<Item>());
        ArrayList<Item> movieList = new ArrayList<>();
        movieList.add(new Movie("Harry", 2001, "yap", "3"));
        movieList.add(new Movie("Dave", 2005, "blah", "unrated"));
        LibrarySection movieLibrarySection = new LibrarySection("Movie", movieList, new ArrayList<Item>());
        Parser parser = new Parser(bookLibrarySection, movieLibrarySection);
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication(view, parser);
        bibliotecaApplication.start();
    }
}
