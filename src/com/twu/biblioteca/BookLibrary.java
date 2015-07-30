package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLibrary implements MenuOption {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLibrary that = (BookLibrary) o;

        return !(bookList != null ? !bookList.equals(that.bookList) : that.bookList != null);

    }

    @Override
    public int hashCode() {
        return bookList != null ? bookList.hashCode() : 0;
    }

    @Override
    public void execute(View view) {
        for(Book book : bookList) {
            view.printToConsole(book.toString() + "\n");
        }
    }

    @Override
    public String checkOutItem(String item) {
        for(Book book : bookList) {
            if(book.isTitled(item))
                if(book.checkOut())
                    return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }
}
