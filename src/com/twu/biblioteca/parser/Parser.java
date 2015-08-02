package com.twu.biblioteca.parser;


import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operations.*;

public class Parser {
    Library bookLibrary;
    Library movieLibrary;

    public Parser(Library bookLibrary, Library movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
    }

    public Operation selectOperation(String userInput) {
        switch (userInput) {
            case "List Books" : return new ListOperation(bookLibrary);

            case "List Movies" : return new ListOperation(movieLibrary);

            case "CheckOut Book" :return new CheckOutOperation(bookLibrary);

            case "CheckOut Movie" :return new CheckOutOperation(movieLibrary);

            case "Return Book" : return new ReturnItemOperation(bookLibrary);

            case "Return Movie" : return new ReturnItemOperation(movieLibrary);

            case "Quit" : return new QuitOperation();
        }
        return new InvalidOperation();
    }
}
