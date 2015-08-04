package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibrarianTest {

    Librarian librarian;

    @Before
    public void initialise() {
        librarian = new Librarian("Admin", "asd");
    }

    @Test
    public void shouldConfirmTheCredentials() {
        assertEquals(true, librarian.hasCredentials("Admin", "asd"));
    }
}
