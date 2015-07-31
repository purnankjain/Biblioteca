package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ListBooksOptionTest {

    @Test
    public void shouldReturnBookDetails() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        ListBooksOption listBooksOption = new ListBooksOption("List Books", mockBookLibrary);
        ArrayList<String> allBookDetails = new ArrayList<String>();
        allBookDetails.add("Book1");

        when(mockBookLibrary.getAllBooks()).thenReturn(allBookDetails);

        assertEquals("Book1\n", listBooksOption.listBooks());
    }
}
