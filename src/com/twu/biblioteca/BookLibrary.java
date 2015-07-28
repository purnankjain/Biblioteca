package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary {
    private ArrayList<String> bookList;

    public BookLibrary(ArrayList<String> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<String> getAllBooks() {
        return bookList;
    }
}
