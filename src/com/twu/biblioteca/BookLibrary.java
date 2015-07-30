package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> unAvailableBookList;

    public BookLibrary(ArrayList<Book> availableBookList, ArrayList<Book> unAvailableBookList) {
        this.availableBookList = availableBookList;
        this.unAvailableBookList = unAvailableBookList;
    }

    public ArrayList<String> getAllBooks() {
        ArrayList<String> tempList = new ArrayList<String>();
        for(Book book : availableBookList) {
            tempList.add(book.toString());
        }
        return tempList;
    }

    public String checkOutItem(String item) {
        for(Book book : availableBookList) {
            if(book.isTitled(item)) {
                unAvailableBookList.add(book);
                availableBookList.remove(book);
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available.";
    }

    public String returnThisItem(String item) {
        for(Book book : unAvailableBookList) {
            if(book.isTitled(item)) {
                availableBookList.add(book);
                unAvailableBookList.remove(book);
                return "Thank you for returning the book.";
            }
        }
        return "That is not a valid book to return.";
    }
}
