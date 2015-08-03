package com.twu.biblioteca.parser;


import com.twu.biblioteca.ConfirmationHandler;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.operations.*;

public class Parser {
    LibrarySection bookLibrarySection;
    LibrarySection movieLibrarySection;
    ConfirmationHandler confirmationHandler;

    public Parser(LibrarySection bookLibrarySection, LibrarySection movieLibrarySection, ConfirmationHandler confirmationHandler) {
        this.bookLibrarySection = bookLibrarySection;
        this.movieLibrarySection = movieLibrarySection;
        this.confirmationHandler = confirmationHandler;
    }

    public Operation selectOperation(String userInput) {
        switch (userInput) {
            case "List Books" : return new ListOperation(bookLibrarySection);

            case "List Movies" : return new ListOperation(movieLibrarySection);

            case "CheckOut Book" :return new CheckOutOperation("Book", bookLibrarySection, confirmationHandler);

            case "CheckOut Movie" :return new CheckOutOperation("Movie", movieLibrarySection, confirmationHandler);

            case "Return Book" : return new ReturnItemOperation("Book", bookLibrarySection, confirmationHandler);

            case "Return Movie" : return new ReturnItemOperation("Movie", movieLibrarySection, confirmationHandler);

            case "Quit" : return new QuitOperation();
        }
        return new InvalidOperation();
    }
}
