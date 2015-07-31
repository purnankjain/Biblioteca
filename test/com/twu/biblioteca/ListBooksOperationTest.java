package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ListBooksOperationTest {

    @Test
    public void shouldReturnBookDetails() {
        BookLibrary mockBookLibrary = mock(BookLibrary.class);
        ListBooksOperation listBooksOperation = new ListBooksOperation("List Books", mockBookLibrary);
        ArrayList<String> allBookDetails = new ArrayList<String>();
        allBookDetails.add("Book1");

        when(mockBookLibrary.getAllBooks()).thenReturn(allBookDetails);

        assertEquals("Book1\n", listBooksOperation.listBooks());
    }
}
