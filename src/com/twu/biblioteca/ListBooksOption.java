package com.twu.biblioteca;

import java.util.ArrayList;

public class ListBooksOption implements MenuOption{
    String name;
    BookLibrary bookLibrary;

    public ListBooksOption(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public void execute(View view) {
        view.printToConsole(listBooks());
    }

    @Override
    public String toString() {
        return name;
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
