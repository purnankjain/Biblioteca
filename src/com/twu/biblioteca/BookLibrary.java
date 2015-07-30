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

    public String checkOutItem(String item) {
        for(Book book : bookList) {
            if(book.isTitled(item))
                if(book.checkOutThis())
                    return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }
}
