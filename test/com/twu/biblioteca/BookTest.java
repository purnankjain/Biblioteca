package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void shouldKnowIfItIsASpecificBook() {
        Book book = new Book("Harry Potter", "J.K. Rowling", 1998);

        assertEquals(true, book.isTitled("Harry Potter"));
    }

    @Test
    public void shouldCheckOut() {
        Book book = new Book("Harry Potter", "J.K. Rowling", 1998);

        assertEquals(true, book.checkOut());
    }
}
