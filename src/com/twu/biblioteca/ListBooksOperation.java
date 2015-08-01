package com.twu.biblioteca;

import java.util.ArrayList;


public class ListBooksOperation implements Operation {
    String name;
    BookLibrary bookLibrary;

    public ListBooksOperation(String name, BookLibrary bookLibrary) {
        this.name = name;
        this.bookLibrary = bookLibrary;
    }

    @Override
    public boolean execute(View view) {
        view.printToConsole(listBooks());
        return true;
    }

    @Override
    public boolean nameEquals(String toCheck) {
        return name.equals(toCheck);
    }

    public String listBooks() {
        ArrayList<String> arrayList = bookLibrary.getAllBooks();
        String formattedOutput = "";
        for(String eachBookDetail : arrayList) {
            formattedOutput += eachBookDetail + "\n";
        }
        return formattedOutput;
    }

    public String getName() {
        return name;
    }
}
