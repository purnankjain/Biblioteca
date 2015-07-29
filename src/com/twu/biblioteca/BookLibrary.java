package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary {
    private ArrayList<Book> bookList;

    public BookLibrary(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<String> getAllBooks() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Book book : bookList) {
            tempList.add(book.toString());
        }
        return tempList;
    }
}
