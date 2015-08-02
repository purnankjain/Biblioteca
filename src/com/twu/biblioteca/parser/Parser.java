package com.twu.biblioteca.parser;


import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.operations.*;

public class Parser {
    LibrarySection bookLibrarySection;
    LibrarySection movieLibrarySection;

    public Parser(LibrarySection bookLibrarySection, LibrarySection movieLibrarySection) {
        this.bookLibrarySection = bookLibrarySection;
        this.movieLibrarySection = movieLibrarySection;
    }

    public Operation selectOperation(String userInput) {
        switch (userInput) {
            case "List Books" : return new ListOperation(bookLibrarySection);

            case "List Movies" : return new ListOperation(movieLibrarySection);

            case "CheckOut Book" :return new CheckOutOperation(bookLibrarySection);

            case "CheckOut Movie" :return new CheckOutOperation(movieLibrarySection);

            case "Return Book" : return new ReturnItemOperation(bookLibrarySection);

            case "Return Movie" : return new ReturnItemOperation(movieLibrarySection);

            case "Quit" : return new QuitOperation();
        }
        return new InvalidOperation();
    }
}
