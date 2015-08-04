package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class User {
    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> books;

    public User(String id, String password, String name, String email, String phoneNumber, ArrayList<Book> books) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public boolean hasBook(Book book) {
        for(Book thisBook : books) {
            if(thisBook.equals(book)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + email + " " + phoneNumber;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
