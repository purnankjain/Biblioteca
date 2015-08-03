package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class User {
    private String id;
    private String password;
    private ArrayList<Book> books;

    public User(String id, String password, ArrayList<Book> books) {
        this.id = id;
        this.password = password;
        this.books = books;
    }

    public boolean hasCredentials(String thatId, String thatPassword) {
        return (id.equals(thatId) && password.equals(thatPassword));
    }

    public void addBookToUserBookList(Book book) {
        books.add(book);
    }
    
    public ArrayList<Book> getAllBooks() {
        return books;
    }
}
