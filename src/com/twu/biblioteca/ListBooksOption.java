package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption implements MenuOption{
    BookLibrary bookLibrary;

    public ListBooksOption(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute(View view) {

    }

    @Override
    public String checkOutItem(String item) {
        return null;
    }

    public String listBooks() {
        ArrayList<String> arrayList = bookLibrary.getAllBooks();
        String formattedOutput = "";
        for(String eachBookDetail : arrayList) {
            formattedOutput += eachBookDetail + "\n";
        }
        return formattedOutput;
    }
}
