package com.twu.biblioteca;

import com.twu.biblioteca.operations.*;
import com.twu.biblioteca.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class ParserTest {

    Parser parser;
    LibrarySection bookLibrarySection;
    LibrarySection movieLibrarySection;
    ConfirmationHandler confirmationHandler;

    @Before
    public void initialise() {
        bookLibrarySection = mock(LibrarySection.class);
        movieLibrarySection = mock(LibrarySection.class);
        confirmationHandler = mock(ConfirmationHandler.class);
        parser = new Parser(bookLibrarySection, movieLibrarySection, confirmationHandler);
    }

    @Test
    public void shouldReturnListOptionWithBooks() {

        assertEquals(ListOperation.class, parser.selectOperation("List Books").getClass());
    }

    @Test
    public void shouldReturnListOptionWithMovies() {

        assertEquals(ListOperation.class, parser.selectOperation("List Movies").getClass());
    }

    @Test
    public void shouldReturnQuitOption() {

        assertEquals(QuitOperation.class, parser.selectOperation("Quit").getClass());
    }

    @Test
    public void shouldReturnInvalidMenuOption() {

        assertEquals(InvalidOperation.class, parser.selectOperation("Blah").getClass());
    }

    @Test
    public void shouldReturnCheckOutOptionWithBooks() {

        assertEquals(CheckOutOperation.class, parser.selectOperation("CheckOut Book").getClass());
    }

    @Test
    public void shouldReturnReturnOptionWithBooks() {

        assertEquals(ReturnItemOperation.class, parser.selectOperation("Return Book").getClass());
    }
}
